package com.medica.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Tbl_Usuario {
	private int id;
    private String username;
    private String password;
    // Información personal
    private String nombre;
    private String apellido;
    private String dni; // o número de identificación nacional
    private Tbl_Genero genero; // MASCULINO, FEMENINO, OTRO
    //Cambiamos el LocalDate por String
    private String fechaNacimiento;
    // Información de contacto
    private String email;
    private String telefono;
    private String direccion;
    // Información laboral
    private String cargo; // ej: "Secretario/a de Consultorio"
    private String departamento; // ej: "Atención al paciente", "Recepción"
    //Cambiamos el LocalDate por String
    private String fechaIngreso; // cuándo empezó a trabajar
    private boolean activo; // si está activo en el sistema
    // Auditoría del sistema
    //Cambiamos el LocalDateTime por String
    private String fechaCreacion;
    //Cambiamos el LocalDateTime por String
    private String ultimoAcceso;
    private int intentosFallidos;

    public Tbl_Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Tbl_Usuario(int id, String username, String password, String nombre, String apellido, String dni,
			Tbl_Genero genero, String fechaNacimiento, String email, String telefono, String direccion, String cargo,
			String departamento, String fechaIngreso, boolean activo, String fechaCreacion, String ultimoAcceso,
			int intentosFallidos) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.cargo = cargo;
		this.departamento = departamento;
		this.fechaIngreso = fechaIngreso;
		this.activo = activo;
		this.fechaCreacion = fechaCreacion;
		this.ultimoAcceso = ultimoAcceso;
		this.intentosFallidos = intentosFallidos;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Tbl_Genero getGenero() {
		return genero;
	}

	public void setGenero(Tbl_Genero genero) {
		this.genero = genero;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(String ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	public int getIntentosFallidos() {
		return intentosFallidos;
	}

	public void setIntentosFallidos(int intentosFallidos) {
		this.intentosFallidos = intentosFallidos;
	}

	
	
	
    

}