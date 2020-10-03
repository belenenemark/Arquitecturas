package edu.isistan.jparepository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.isistan.dto.DTOReporteInscriptos;
import edu.isistan.entidad.Carrera;
import edu.isistan.entidad.Estudiante;
import edu.isistan.entidad.Matricula;
/**
 * @author Belen Enemark
 * @author Juan Deccechis
 * @author Mateo Zarrabeitia
 * Esta clase se ocupa  de insertar, actualizar y eliminar estudiante*/
public class MatriculaJPARepository implements Serializable, GenericRepository<Matricula, Object> {

	private static final long serialVersionUID = -6284052128342094661L;
	private EntityManagerFactory emf = null;
	private static MatriculaJPARepository matricula;

	/** Constructor que levanta el entity manager factory*/
	public MatriculaJPARepository() {
		this.emf = Persistence.createEntityManagerFactory("Example");
	}
	
	public static MatriculaJPARepository getInstance() {
		if(matricula == null)
			matricula = new MatriculaJPARepository();
		return matricula;
	}
	
	
	
	/** Inserta una matricula en la base de datos 
	 * @param matricula objeto Matricula corresponde a la inscripcion a una carrera de un alumno
	 * */
	@Override
	public Matricula insert(Matricula matricula) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			if(this.getMatricula(matricula.getCarrera(), matricula.getEstudiante()) != null) {
				System.out.println("El alumno ya se encuentra matriculado en la carrera");
				return null;
			} else {
				em.getTransaction().begin();
				em.persist(matricula);
				em.getTransaction().commit();
				return matricula;
			}


		} catch (Exception e) {
			throw new RuntimeException("Error parsing date", e);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	/** Actualiza la matricula en la base de datos, primero la busca 
	 * @param matricula objeto Matricula corresponde a la inscripcion a una carrera de un alumno */
	@Override
	public void update(Matricula matricula) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			matricula = em.merge(matricula);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	/** Borra una matricula de la base de datos
	 * @param matricula */
	@Override
	public void delete(Object matricula) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(matricula);
			em.getTransaction().commit(); 
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	@Override
	public List<Matricula> getALL() {
		EntityManager em = emf.createEntityManager();
		List<Matricula> listado = em.createQuery("SELECT M FROM Matricula M", Matricula.class)
				.getResultList();

		return listado;
	}
	@Override
	public Matricula getId(Object id) {
		String[] tokens = ((String) id).split("/");
		EntityManager em = emf.createEntityManager();
		List<Matricula> matricula = em.createQuery("SELECT M FROM Matricula M WHERE M.estudiante.lu =:ides AND M.carrera.id =:idca", Matricula.class)
				.setParameter("ides", Integer.valueOf(tokens[0]))
				.setParameter("idca", Integer.valueOf(tokens[1]))
				.getResultList();

		return matricula.get(0);
	}
	

	/** Obtener una matricula por Carrera y Estudiante
	 * @param idCarrera identificador de carrera de la tabla carrera
	 * @param idEstudiante identificador de estudiante de la tabla estudiante
	 * @return listado.get(0) retorna el listado en la posicion 0*/
	public Matricula getMatricula(Carrera idCarrera, Estudiante idEstudiante) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Matricula M WHERE M.id_estudiante =:es AND M.id_carrera =:ca ", Matricula.class)
				.setParameter("es", idEstudiante).
				setParameter("ca", idCarrera);
		List<Matricula> listado = q.getResultList();

		if (listado.size() == 0) {
			return null;
		} else {
			return listado.get(0);		
		}

	}
	/**Obtener un reporte de la cantidad de inscriptos y egresados por año y carrera. Aqui se opto por hacer la union de las diferentes tablas
	 * entendemos que no es la forma mas eficionete pero es la unica que encontramos
	 * @return listado listado con los datos del cruce entre inscriptos, egresados, año y carrera. 
	 * */
	public List<DTOReporteInscriptos> getReporte() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNativeQuery("(SELECT row_number() OVER () as \"id\",\r\n" + 
				"c.nombre_carrera AS \"nombreCarrera\",\r\n" + 
				"SUM(if(m.graduado = '1', 0, 0)) AS \"cantInscriptos\", \r\n" + 
				"count(c.id) AS \"cantEgresados\", \r\n" + 
				"extract(year from m.fecha_egreso) AS \"anio\"\r\n" + 
				"FROM Carrera c\r\n" + 
				"JOIN Matricula m ON m.id_carrera = c.id \r\n" + 
				"WHERE m.graduado = \"1\" \r\n" + 
				"GROUP BY extract(year from m.fecha_egreso), c.id\r\n" + 
				"ORDER BY c.nombre_carrera ASC, extract(year from m.fecha_egreso) ASC)\r\n" + 
				"UNION\r\n" + 
				"(SELECT row_number() OVER () as \"id\",\r\n" + 
				"c.nombre_carrera AS \"nombreCarrera\",\r\n" + 
				"count(c.id) AS \"cantInscriptos\" ,\r\n" + 
				"SUM(if(m.graduado = '1', 0, 0)) AS \"cantEgresados\",\r\n" + 
				"extract(year from m.fecha_inscripcion) AS \"anio\"\r\n" + 
				"FROM Carrera c\r\n" + 
				"JOIN Matricula m ON m.id_carrera = c.id\r\n" + 
				"GROUP BY extract(year from m.fecha_inscripcion), c.id\r\n" + 
				"ORDER BY c.nombre_carrera ASC, extract(year from m.fecha_inscripcion) ASC) \r\n" + 
				"ORDER BY nombreCarrera ASC, anio ASC", "DTOReporteInscriptos");
		List<DTOReporteInscriptos> listado = q.getResultList();
		return listado;
	}
	

}
