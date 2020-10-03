package edu.isistan.dto;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

import edu.isistan.entidad.Estudiante;

public class DTOEstudiante {

	private int lu;
	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	private int dni;
	private String ciudad_residencia;
	private String nombre_carrera;
	public int getLu() {
		return lu;
	}
	public void setLu(int lu) {
		this.lu = lu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getCiudad_residencia() {
		return ciudad_residencia;
	}
	public void setCiudad_residencia(String ciudad_residencia) {
		this.ciudad_residencia = ciudad_residencia;
	}
	public String getNombre_carrera() {
		return nombre_carrera;
	}
	public void setNombre_carrera(String nombre_carrera) {
		this.nombre_carrera = nombre_carrera;
	}
	
	public DTOEstudiante(int lu, String nombre, String apellido, int edad, String genero, int dni,
			String ciudad_residencia, String nombre_carrera) {
		super();
		this.lu = lu;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
		this.ciudad_residencia = ciudad_residencia;
		this.nombre_carrera = nombre_carrera;
	}
	public DTOEstudiante() {
		super();
	}
	
	
	
	
}
