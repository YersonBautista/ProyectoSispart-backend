package com.unbosque.sispart.app.huespedes.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unbosque.sispart.app.huespedes.entity.Nacionalidad;
import com.unbosque.sispart.app.huespedes.entity.TipoDocumento;

public class HuespedDto {

	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String direccion;
	@NotBlank
	private Long num_celular;
	@Email
	private String correo;
	@NotBlank
	private TipoDocumento id_tip_documento;
	@NotBlank
	private Integer numDocumento;
	@NotBlank
	private Nacionalidad id_nacionalidad;
	@NotBlank
	private String lugar_origen;

	private String nom_contacto_emergencia;
	private Long num_contacto_emergencia;

	@NotBlank
	private Integer num_acompañantes;
	@NotBlank
	private Integer dias_aprox_estadia;

	@NotBlank
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fecha_ingreso;

	@NotBlank
	@JsonFormat(pattern = "HH:mm:ss")
	private Date hora_ingreso;

	public HuespedDto() {

	}

	public HuespedDto(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String direccion,
			@NotBlank Long num_celular, @Email String correo, @NotBlank TipoDocumento id_tip_documento,
			@NotBlank Integer numDocumento, @NotBlank Nacionalidad id_nacionalidad, @NotBlank String lugar_origen,
			String nom_contacto_emergencia, Long num_contacto_emergencia, @NotBlank Integer num_acompañantes,
			@NotBlank Integer dias_aprox_estadia, @NotBlank Date fecha_ingreso, @NotBlank Date hora_ingreso) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.num_celular = num_celular;
		this.correo = correo;
		this.id_tip_documento = id_tip_documento;
		this.numDocumento = numDocumento;
		this.id_nacionalidad = id_nacionalidad;
		this.lugar_origen = lugar_origen;
		this.nom_contacto_emergencia = nom_contacto_emergencia;
		this.num_contacto_emergencia = num_contacto_emergencia;
		this.num_acompañantes = num_acompañantes;
		this.dias_aprox_estadia = dias_aprox_estadia;
		this.fecha_ingreso = fecha_ingreso;
		this.hora_ingreso = hora_ingreso;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getNum_celular() {
		return num_celular;
	}

	public void setNum_celular(Long num_celular) {
		this.num_celular = num_celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public TipoDocumento getId_tip_documento() {
		return id_tip_documento;
	}

	public void setId_tip_documento(TipoDocumento id_tip_documento) {
		this.id_tip_documento = id_tip_documento;
	}

	public Integer getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(Integer numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Nacionalidad getId_nacionalidad() {
		return id_nacionalidad;
	}

	public void setId_nacionalidad(Nacionalidad id_nacionalidad) {
		this.id_nacionalidad = id_nacionalidad;
	}

	public String getLugar_origen() {
		return lugar_origen;
	}

	public void setLugar_origen(String lugar_origen) {
		this.lugar_origen = lugar_origen;
	}

	public String getNom_contacto_emergencia() {
		return nom_contacto_emergencia;
	}

	public void setNom_contacto_emergencia(String nom_contacto_emergencia) {
		this.nom_contacto_emergencia = nom_contacto_emergencia;
	}

	public Long getNum_contacto_emergencia() {
		return num_contacto_emergencia;
	}

	public void setNum_contacto_emergencia(Long num_contacto_emergencia) {
		this.num_contacto_emergencia = num_contacto_emergencia;
	}

	public Integer getNum_acompañantes() {
		return num_acompañantes;
	}

	public void setNum_acompañantes(Integer num_acompañantes) {
		this.num_acompañantes = num_acompañantes;
	}

	public Integer getDias_aprox_estadia() {
		return dias_aprox_estadia;
	}

	public void setDias_aprox_estadia(Integer dias_aprox_estadia) {
		this.dias_aprox_estadia = dias_aprox_estadia;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getHora_ingreso() {
		return hora_ingreso;
	}

	public void setHora_ingreso(Date hora_ingreso) {
		this.hora_ingreso = hora_ingreso;
	}

}
