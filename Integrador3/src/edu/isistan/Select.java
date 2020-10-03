package edu.isistan;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.isistan.dto.DTOReporteInscriptos;
import edu.isistan.entidad.Carrera;
import edu.isistan.entidad.Estudiante;
import edu.isistan.entidad.Matricula;
import edu.isistan.jparepository.CarreraJPARepository;
import edu.isistan.jparepository.EstudianteJPARepository;
import edu.isistan.jparepository.MatriculaJPARepository;
/** Esta clase ejecuta los diferentes incisos que tienen que ver con insercion de datos
 * @author Belen Enemark
 * @author Juan Deccechis
 * @author Mateo Zarrabeitia*/
public class Select {

	public static void main(String[] args) throws ParseException {
		
		Date parsedDate = new Date(System.currentTimeMillis());
		Timestamp fecha = new java.sql.Timestamp(parsedDate.getTime());


		//PUNTO 2
		//INCISO A) DAR DE ALTA UN ESTUDIANTE
		EstudianteJPARepository ejpa = new EstudianteJPARepository();
		Estudiante e1 = new Estudiante("Juan", "Perez", 18, "M", 12325678, "Tandil");
		ejpa.insert(e1);

		//INCISO B) MATRICULAR UN ESTUDIANTE
		CarreraJPARepository cjpa = new CarreraJPARepository();
		Carrera c1 = cjpa.getId(1);
		if (c1 == null) {
			c1 = new Carrera(1, "Tudai");
			cjpa.insert(c1);
		}
		
		MatriculaJPARepository mjpa = new MatriculaJPARepository();
		Matricula m1 = new Matricula(e1, c1,fecha, false);
		mjpa.insert(m1);

		//INCISO C) LISTAR TODOS LOS ESTUDIANTES -( EN ESTE CASO ORDENADOS POR APELLIDO)
		System.out.println("------------------------------------------");
		System.out.println("ESTUDIANTES ORDENADOS POR APELLIDO");
		for (Estudiante estudiantes : ejpa.getEstudiantesOrdenados("ASC")) {
			System.out.println(estudiantes);
		}

		//INCISO D) RECUPERAR UN ESTUDIANTE POR NUMERO DE LIBRETA -( EN ESTE CASO EL NUMERO DE LU 1)
		System.out.println("------------------------------------------");
		System.out.println("ESTUDIANTES POR LU");
		System.out.println(ejpa.getId(1));

		//INCISO E) RECUPERAR TODOS LOS ESTUDIANTES POR GENERO
		System.out.println("------------------------------------------");
		System.out.println("ESTUDIANTES POR GENERO");
		for (Estudiante estudiantes : ejpa.getEstudiantesGenero("F")) {
			System.out.println(estudiantes);
		}

		
		//INCISO F) RECUPERAR LAS CARRERAS CON ESTUDIANTES INSCRIPTOS Y ORDENAR POR CANTIDAD DE INSCRIPTOS
		
		System.out.println("------------------------------------------");
		System.out.println("CARRERAS ORDENADAS POR CANTIDAD DE INSCRIPTOS");
		for (Carrera carreras : cjpa.getCarrerasOrdCantEstudiantes()) {
			System.out.println(carreras);
		}
		
		//INCISO G) RECUPERAR TODOS LOS ESTUDIANTES DE UNA DETERMINADA CIUDAD Y CARRERA
		System.out.println("------------------------------------------");
		System.out.println("ESTUDIANTES DE TUDAI Y TANDIL");
		for (Estudiante estudiantes : ejpa.getEstudiantesCarreraCiudad("Tudai", "Tandil")) {
			System.out.println(estudiantes);
		}
		
		
		//PUNTO3
		//GENERAR UN REPORTE QUE MUESTRE LAS CARRERAS CON LA CANTIDAD DE INSCRIPTOS Y EGRESADOS POR AÑO ORDENADOS POR NOMBRE Y AÑO
		System.out.println("------------------------------------------");
		System.out.println("REPORTE CARRERAS");
		System.out.println("CARRERA CANTINSCRIPTOS CANTEGRESADOS ANIO");
		for (DTOReporteInscriptos reporte : mjpa.getReporte()) {
			System.out.print(reporte);
			System.out.println();
		}
		
		ejpa.getId(1);
		

	}

}
