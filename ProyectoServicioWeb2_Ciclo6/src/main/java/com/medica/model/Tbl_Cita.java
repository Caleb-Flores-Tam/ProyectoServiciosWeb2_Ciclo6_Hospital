package com.medica.model;

import java.time.LocalDateTime;

public class Tbl_Cita {

	 private int idCitas;
	 private Tbl_Medico IdMedico;
	 private Tbl_Paciente IdPaciente;
	 private Tbl_Usuario IdUsuario;
	 private LocalDateTime FechaCreacion;
	 private String FechaAtencion;
	 private String Motivo;
	
	 public Tbl_Cita() {
		// TODO Auto-generated constructor stub
	}

	public Tbl_Cita(int idCitas, Tbl_Medico idMedico, Tbl_Paciente idPaciente, Tbl_Usuario idUsuario,
			LocalDateTime fechaCreacion, String fechaAtencion, String motivo) {
		this.idCitas = idCitas;
		IdMedico = idMedico;
		IdPaciente = idPaciente;
		IdUsuario = idUsuario;
		FechaCreacion = fechaCreacion;
		FechaAtencion = fechaAtencion;
		Motivo = motivo;
	}

	public int getIdCitas() {
		return idCitas;
	}

	public void setIdCitas(int idCitas) {
		this.idCitas = idCitas;
	}

	public Tbl_Medico getIdMedico() {
		return IdMedico;
	}

	public void setIdMedico(Tbl_Medico idMedico) {
		IdMedico = idMedico;
	}

	public Tbl_Paciente getIdPaciente() {
		return IdPaciente;
	}

	public void setIdPaciente(Tbl_Paciente idPaciente) {
		IdPaciente = idPaciente;
	}

	public Tbl_Usuario getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Tbl_Usuario idUsuario) {
		IdUsuario = idUsuario;
	}

	public LocalDateTime getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}

	public String getFechaAtencion() {
		return FechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		FechaAtencion = fechaAtencion;
	}

	public String getMotivo() {
		return Motivo;
	}

	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	
	
	 
	 
}
