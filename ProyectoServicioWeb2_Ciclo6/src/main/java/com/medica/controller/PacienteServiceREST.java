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

import org.springframework.web.bind.annotation.CrossOrigin;

import com.medica.model.Tbl_Paciente;
import com.medica.service.imp.ClassPacienteImp;

@Path("/Paciente")
@CrossOrigin(origins = "http://localhost:4200")
public class PacienteServiceREST {
	ClassPacienteImp crud = new ClassPacienteImp();

	// ===== Listado =====
    @GET
    @Path("/ListadoPaciente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPacientes() {
        List<Tbl_Paciente> lista = crud.listadoPacientes();
        return Response.ok(lista).build();
    }
    
    @POST
    @Path("/CrearPaciente")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearPaciente(Tbl_Paciente paciente) {
        crud.registrarPaciente(paciente);
        return Response.status(Response.Status.CREATED).build();
    }
    // ===== BUSCAR PACIENTE POR ID =====
    @GET
    @Path("/BuscarPaciente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPaciente(@PathParam("id") int id) {
        Tbl_Paciente pac = new Tbl_Paciente();
        pac.setCod_pac(id);
        Tbl_Paciente encontrado = crud.buscarPaciente(pac);

        if (encontrado.getCod_pac() == 0) {
            // No encontrado
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("{\"mensaje\":\"Paciente no encontrado\"}")
                           .build();
        }

        return Response.ok(encontrado).build();
    }
    // ===== ELIMINAR PACIENTE =====
    @DELETE
    @Path("/EliminarPaciente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminarPaciente(@PathParam("id") int id) {
        Tbl_Paciente pac = new Tbl_Paciente();
        pac.setCod_pac(id);
        crud.eliminarPaciente(pac);
        return Response.ok("{\"mensaje\":\"Paciente eliminado correctamente\"}").build();
    }
    
 // ===== ACTUALIZAR PACIENTE =====
    @PUT
    @Path("/ActualizarPaciente")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarPaciente(Tbl_Paciente paciente) {
        Tbl_Paciente existente = crud.buscarPaciente(paciente);

        if (existente == null || existente.getCod_pac() == 0) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("{\"mensaje\":\"Paciente no encontrado\"}")
                           .build();
        }

        crud.actualizarPaciente(paciente);
        return Response.ok("{\"mensaje\":\"Paciente actualizado correctamente\"}").build();
    }
	
	
}
