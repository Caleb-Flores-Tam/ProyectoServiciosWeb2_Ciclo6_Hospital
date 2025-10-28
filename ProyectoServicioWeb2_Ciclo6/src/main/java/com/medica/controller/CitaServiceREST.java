package com.medica.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.medica.model.Tbl_Cita;
import com.medica.model.Tbl_Medico;
import com.medica.service.imp.ClassCitaImp;

@Path("/Citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaServiceREST {
	ClassCitaImp crud = new ClassCitaImp();
	
	@GET
	@Path("/ListarCitas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListadoCitas(){
		List<Tbl_Cita> listar = crud.ListaCitas();
		return Response.ok(listar).build();
	}
	
	@POST
	@Path("/RegistrarCitas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response RegistrarCitas(Tbl_Cita cita){
		crud.RegistrarCita(cita);
		return Response.status(Status.CREATED).build();
	}
	
	@GET
	@Path("/BuscarCitas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarCitaPorId(@PathParam("id")int id ){
		Tbl_Cita cita = new Tbl_Cita();
		cita.setIdCitas(id);
		Tbl_Cita resultado = crud.buscarCitaId(cita);
		if(resultado.getIdCitas()==0){
			return Response.status(Status.NOT_FOUND)
					.entity("{\"mensaje\":\"No se encontró Cita con ID " + id + "\"}")
	    			.build();
		}
		return Response.ok(resultado).build();
	}
	
	@PUT
    @Path("/ActualizarCitas")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarCita(Tbl_Cita cita){
		crud.ActualizarCita(cita);
		return Response.ok(cita).build();
	}
	
	@DELETE
    @Path("/EliminarCitas/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response EliminarCita(@PathParam("id") int id ){
		Tbl_Cita cita = new Tbl_Cita();
		cita.setIdCitas(id);
		crud.EliminarCita(cita);
		return Response.ok().build();
	}

}
