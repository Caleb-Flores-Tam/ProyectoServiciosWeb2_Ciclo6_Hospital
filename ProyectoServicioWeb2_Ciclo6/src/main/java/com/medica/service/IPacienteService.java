package com.medica.service;

import java.util.List;

import com.medica.model.Tbl_Paciente;

public interface IPacienteService {
	void registrarPaciente(Tbl_Paciente paciente);
    void actualizarPaciente(Tbl_Paciente paciente);
    void eliminarPaciente(Tbl_Paciente paciente);
    List<Tbl_Paciente> listadoPacientes();
    Tbl_Paciente buscarPaciente(Tbl_Paciente paciente);
}
