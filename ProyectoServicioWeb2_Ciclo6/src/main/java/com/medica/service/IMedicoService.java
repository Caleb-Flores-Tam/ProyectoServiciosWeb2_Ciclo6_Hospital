package com.medica.service;

import java.util.List;

import com.medica.model.Tbl_Medico;


public interface IMedicoService {
	List<Tbl_Medico> ListarMedico();
	void RegistrarMedico(Tbl_Medico medico);
	void ActualizarMedico(Tbl_Medico medico);
	void EliminarMedico(Tbl_Medico medico);
	Tbl_Medico buscarMedicoId(Tbl_Medico medico);
	
	
}
