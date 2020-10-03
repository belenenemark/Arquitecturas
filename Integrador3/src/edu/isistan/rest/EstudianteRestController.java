package edu.isistan.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectReader;

import edu.isistan.dto.DTOEstudiante;
import edu.isistan.entidad.Estudiante;
import edu.isistan.jparepository.EstudianteJPARepository;

@Path("/estudiantes")
public class EstudianteRestController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DTOEstudiante> getAllEstudiantes() {
		List<DTOEstudiante> lista = new ArrayList();
		for (Estudiante estudiante : EstudianteJPARepository.getInstance().getALL()) {
			DTOEstudiante dto= new DTOEstudiante();
			dto.setLu(estudiante.getLu());
			dto.setDni(estudiante.getDni());
			dto.setEdad(estudiante.getEdad());
			dto.setNombre(estudiante.getNombre());
			dto.setApellido(estudiante.getApellido());
			dto.setCiudad_residencia(estudiante.getCiudad_residencia());
			dto.setGenero(estudiante.getGenero());
			if (!estudiante.getCarreras().isEmpty()) {
				dto.setNombre_carrera(estudiante.getCarreras().get(0).getCarrera().getNombre_carrera());
			}
			lista.add(dto);
		}
		return lista;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DTOEstudiante getIdEstudiante(@PathParam("id") String msg) {
		Integer id = Integer.valueOf(msg);
		Estudiante estudiante = EstudianteJPARepository.getInstance().getId(id);
		DTOEstudiante dto= new DTOEstudiante();
		dto.setLu(estudiante.getLu());
		dto.setDni(estudiante.getDni());
		dto.setEdad(estudiante.getEdad());
		dto.setNombre(estudiante.getNombre());
		dto.setApellido(estudiante.getApellido());
		dto.setCiudad_residencia(estudiante.getCiudad_residencia());
		dto.setGenero(estudiante.getGenero());
		if (!estudiante.getCarreras().isEmpty()) {
			dto.setNombre_carrera(estudiante.getCarreras().get(0).getCarrera().getNombre_carrera());
		}
		if(estudiante!=null)
			return dto;
		else
			throw new RecursoNoExiste(id);
	}
	
	@GET
	@Path("/orden/{ord}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DTOEstudiante> getALLEstudiantesOrder(@PathParam("ord") String order) {
		List<DTOEstudiante> lista = new ArrayList();
			for (Estudiante estudiante : EstudianteJPARepository.getInstance().getEstudiantesOrdenados(order)) {
				DTOEstudiante dto= new DTOEstudiante();
				dto.setLu(estudiante.getLu());
				dto.setDni(estudiante.getDni());
				dto.setEdad(estudiante.getEdad());
				dto.setNombre(estudiante.getNombre());
				dto.setApellido(estudiante.getApellido());
				dto.setCiudad_residencia(estudiante.getCiudad_residencia());
				dto.setGenero(estudiante.getGenero());
				if (!estudiante.getCarreras().isEmpty()) {
					dto.setNombre_carrera(estudiante.getCarreras().get(0).getCarrera().getNombre_carrera());
				}
				lista.add(dto);
			}
		return lista;	
	}



	//FORMATO JSON PARA PERSISTIR
//	{
//	    "nombre": "Juan",
//	    "apellido": "Sanchez",
//	    "edad": 18,
//	    "genero": "M",
//	    "dni": 22222143,
//	    "ciudad_residencia": "Tandil"
//	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEstudiante(Estudiante estudiante) {
		estudiante.setLu(-1);
		Estudiante result= EstudianteJPARepository.getInstance().insert(estudiante);
		if(result==null) {
			throw new RecursoDuplicado(estudiante.getLu());
		}else {
			return Response.status(201).entity(estudiante).build();
		}
	}




	public class RecursoDuplicado extends WebApplicationException {
		public RecursoDuplicado(int id) {
			super(Response.status(Response.Status.CONFLICT)
					.entity("El recurso con ID "+id+" ya existe").type(MediaType.TEXT_PLAIN).build());
		}
	}

	public class RecursoNoExiste extends WebApplicationException {
		public RecursoNoExiste(int id) {
			super(Response.status(Response.Status.NOT_FOUND)
					.entity("El recurso con id "+id+" no fue encontrado").type(MediaType.TEXT_PLAIN).build());
		}
	}


}


