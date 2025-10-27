package com.medica.model;

public class Tbl_Especialidades {
	
	private int idEspecialidad;
	private String especialidad;
	private String descEspecialidad;
	
	public Tbl_Especialidades() {
		// TODO Auto-generated constructor stub
	}

	public Tbl_Especialidades(int idEspecialidad, String especialidad, String descEspecialidad) {
		this.idEspecialidad = idEspecialidad;
		this.especialidad = especialidad;
		this.descEspecialidad = descEspecialidad;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDescEspecialidad() {
		return descEspecialidad;
	}

	public void setDescEspecialidad(String descEspecialidad) {
		this.descEspecialidad = descEspecialidad;
	}
	
	
}
