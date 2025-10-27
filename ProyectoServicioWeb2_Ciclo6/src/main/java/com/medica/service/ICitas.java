package com.medica.service;

import java.util.List;

import com.medica.model.Tbl_Cita;

public interface ICitas {
	List<Tbl_Cita> ListaCitas();
	void RegistrarCita(Tbl_Cita cita);
	void ActualizarCita(Tbl_Cita cita);
	void EliminarCita(Tbl_Cita cita);
	Tbl_Cita buscarCitaId(Tbl_Cita cita);

}
