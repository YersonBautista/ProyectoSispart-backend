package com.unbosque.sispart.app.empleados.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unbosque.sispart.app.empleados.entity.Genero;
import com.unbosque.sispart.app.empleados.entity.TipoDocumento;
import com.unbosque.sispart.app.empleados.entity.TipoSangre;

public class EmpleadoDto {

	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private TipoDocumento idTipoDocumento;
	@NotBlank
	private Integer numDocumento;
	@NotBlank
	private Long numTelefono;
	@NotBlank
	@Email
	private String correo;
	@NotBlank
	private String contraseña;
	@NotBlank
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	@NotBlank
	private String direccion;
	@NotBlank
	private String nomContactoEmergencia;
	@NotBlank
	private Long numContactoEmergencia;
	@NotBlank
	private String eps;
	@NotBlank
	private String arl;
	@NotBlank
	private Genero idGenero;
	@NotBlank
	private TipoSangre idTipoSangre;

	public EmpleadoDto() {

	}

	public EmpleadoDto(@NotBlank String nombre, @NotBlank String apellido, @NotBlank TipoDocumento idTipoDocumento,
			@NotBlank Integer numDocumento, @NotBlank Long numTelefono, @NotBlank @Email String correo,
			@NotBlank String contraseña, @NotBlank Date fechaNacimiento, @NotBlank String direccion,
			@NotBlank String nomContactoEmergencia, @NotBlank Long numContactoEmergencia, @NotBlank String eps,
			@NotBlank String arl, @NotBlank Genero idGenero, @NotBlank TipoSangre idTipoSangre) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.idTipoDocumento = idTipoDocumento;
		this.numDocumento = numDocumento;
		this.numTelefono = numTelefono;
		this.correo = correo;
		this.contraseña = contraseña;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.nomContactoEmergencia = nomContactoEmergencia;
		this.numContactoEmergencia = numContactoEmergencia;
		this.eps = eps;
		this.arl = arl;
		this.idGenero = idGenero;
		this.idTipoSangre = idTipoSangre;
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

	public TipoDocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public Integer getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(Integer numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Long getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(Long numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNomContactoEmergencia() {
		return nomContactoEmergencia;
	}

	public void setNomContactoEmergencia(String nomContactoEmergencia) {
		this.nomContactoEmergencia = nomContactoEmergencia;
	}

	public Long getNumContactoEmergencia() {
		return numContactoEmergencia;
	}

	public void setNumContactoEmergencia(Long numContactoEmergencia) {
		this.numContactoEmergencia = numContactoEmergencia;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getArl() {
		return arl;
	}

	public void setArl(String arl) {
		this.arl = arl;
	}

	public Genero getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Genero idGenero) {
		this.idGenero = idGenero;
	}

	public TipoSangre getIdTipoSangre() {
		return idTipoSangre;
	}

	public void setIdTipoSangre(TipoSangre idTipoSangre) {
		this.idTipoSangre = idTipoSangre;
	}

}
