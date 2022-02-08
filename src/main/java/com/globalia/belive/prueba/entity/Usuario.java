package com.globalia.belive.prueba.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellidos;
	@NotEmpty
	@Pattern(regexp = "[0-9]{4}-[0-9]{4}")
	private String telefono;
	@NotEmpty
	@Email
	private String email;
	private String fechadenacimiento;
	@NotEmpty
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}")
	private String contrasena;
	@NotEmpty
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}")
	private String contrasena2;
	
	private boolean paswordsEqual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechadenacimiento() {
		return fechadenacimiento;
	}

	public void setFechadenacimiento(String fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getContrasena2() {
		return contrasena2;
	}

	public void setContrasena2(String contrasena2) {
		this.contrasena2 = contrasena2;
	}
	
	 @AssertTrue(message = "Passwords should match")
	    public boolean isPasswordsEqual() {
	        return (contrasena == null) ? false: contrasena.equals(contrasena2);
	    }

}
