package com.unbosque.sispart.app.huespedes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "huespedes")
public class Huesped implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_huesped;

	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	private String direccion;
	@NotNull
	private Long num_celular;
	@NotNull
	private String correo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tip_documento")
	private TipoDocumento id_tip_documento;
	@NotNull
	@Column(name = "num_documento")
	private Integer numDocumento;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_nacionalidad")
	private Nacionalidad id_nacionalidad;

	@NotNull
	private String lugar_origen;
	
	private String nom_contacto_emergencia;
	private Long num_contacto_emergencia;
	
	@NotNull
	private Integer num_acompañantes;
	@NotNull
	private Integer dias_aprox_estadia;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fecha_ingreso;

	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm:ss")
	
	private Date hora_ingreso;

	public Huesped() {

	}
	
	public Huesped(int id_huesped, @NotNull String nombre, @NotNull String apellido, @NotNull String direccion,
			@NotNull Long num_celular, @NotNull String correo, @NotNull TipoDocumento id_tip_documento,
			@NotNull Integer numDocumento, @NotNull Nacionalidad id_nacionalidad, @NotNull String lugar_origen,
			String nom_contacto_emergencia, Long num_contacto_emergencia, @NotNull Integer num_acompañantes,
			@NotNull Integer dias_aprox_estadia, Date fecha_ingreso, Date hora_ingreso) {
		super();
		this.id_huesped = id_huesped;
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
	
	public Huesped(@NotNull String nombre, @NotNull String apellido, @NotNull String direccion,
			@NotNull Long num_celular, @NotNull String correo, @NotNull TipoDocumento id_tip_documento,
			@NotNull Integer numDocumento, @NotNull Nacionalidad id_nacionalidad, @NotNull String lugar_origen,
			String nom_contacto_emergencia, Long num_contacto_emergencia, @NotNull Integer num_acompañantes,
			@NotNull Integer dias_aprox_estadia, Date fecha_ingreso, Date hora_ingreso) {
		super();
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
	

	public int getId_huesped() {
		return id_huesped;
	}

	public void setId_huesped(int id_huesped) {
		this.id_huesped = id_huesped;
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


	private static final long serialVersionUID = 2426378341826782229L;
}
