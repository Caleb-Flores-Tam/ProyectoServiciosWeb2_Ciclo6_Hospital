package com.medica.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioDTO {
	private int id;
    private String username;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String cargo;
    private boolean activo;
    private String fechaIngreso;
    private String ultimoAcceso;
    
    //Constructor vacio
    public UsuarioDTO(){}
  //Constructor
	public UsuarioDTO(int id, String username, String nombre, String apellido, String email, String telefono,
			String cargo, boolean activo, String fechaIngreso, String ultimoAcceso) {
		this.id = id;
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.cargo = cargo;
		this.activo = activo;
		this.fechaIngreso = fechaIngreso;
		this.ultimoAcceso = ultimoAcceso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getUltimoAcceso() {
		return ultimoAcceso;
	}
	public void setUltimoAcceso(String ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}
	
    
    
	
    
    
}