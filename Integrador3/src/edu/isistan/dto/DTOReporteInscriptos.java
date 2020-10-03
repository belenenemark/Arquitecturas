package edu.isistan.dto;

import java.io.Serializable;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ColumnResult;


@SqlResultSetMapping(
        name = "DTOReporteInscriptos",
        classes = @ConstructorResult(
                targetClass = DTOReporteInscriptos.class,
                columns = {
        	    		@ColumnResult(name="id", type= Long.class),
        	    		@ColumnResult(name="nombreCarrera", type= String.class),
        	    		@ColumnResult(name="cantInscriptos", type=Long.class),
        	    		@ColumnResult(name="cantEgresados", type= Long.class),
        	    		@ColumnResult(name="anio", type= Integer.class)})
        	)


@Entity
public class DTOReporteInscriptos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//SE CREA UN FAKE ID PARA QUE SE PUEDA MAPEAR EL OBJETO YA QUE LA ENTIDAD LO REQUIERE
	@Id
	private Long id;
	private String nombreCarrera;
	private Long cantInscriptos;
	private Long cantEgresados;
	private Integer anio;
	
	
	
	public DTOReporteInscriptos() {
		super();
	}
	public DTOReporteInscriptos(Long id, String nombreCarrera, Long cantInscriptos, Long cantEgresados, Integer anio) {
		super();
		this.id = id;
		this.nombreCarrera = nombreCarrera;
		this.cantInscriptos = cantInscriptos;
		this.cantEgresados = cantEgresados;
		this.anio = anio;
	}
	
	
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	public Long getCantInscriptos() {
		return cantInscriptos;
	}
	public void setCantInscriptos(Long cantInscriptos) {
		this.cantInscriptos = cantInscriptos;
	}
	public Long getCantEgresados() {
		return cantEgresados;
	}
	public void setCantEgresados(Long cantEgresados) {
		this.cantEgresados = cantEgresados;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	@Override
	public String toString() {
		return nombreCarrera + "  |  " + cantInscriptos
				+ "  |  " + cantEgresados + "  |  " + anio;
	}
	
	
	
}
