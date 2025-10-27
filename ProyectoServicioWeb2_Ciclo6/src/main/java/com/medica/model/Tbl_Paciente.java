package com.medica.model;

public class Tbl_Paciente {
	 private int cod_pac;
	 private String dni;
	 private String nombre_pac;
	 private String seguro;
	 private String telefono_pac;
	 private String estado;
	 
	 public Tbl_Paciente() {
		// TODO Auto-generated constructor stub
	}

	public Tbl_Paciente(int cod_pac, String dni, String nombre_pac, String seguro, String telefono_pac, String estado) {
		this.cod_pac = cod_pac;
		this.dni = dni;
		this.nombre_pac = nombre_pac;
		this.seguro = seguro;
		this.telefono_pac = telefono_pac;
		this.estado = estado;
	}

	public int getCod_pac() {
		return cod_pac;
	}

	public void setCod_pac(int cod_pac) {
		this.cod_pac = cod_pac;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre_pac() {
		return nombre_pac;
	}

	public void setNombre_pac(String nombre_pac) {
		this.nombre_pac = nombre_pac;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public String getTelefono_pac() {
		return telefono_pac;
	}

	public void setTelefono_pac(String telefono_pac) {
		this.telefono_pac = telefono_pac;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	 
	
	
	 
	 
}
