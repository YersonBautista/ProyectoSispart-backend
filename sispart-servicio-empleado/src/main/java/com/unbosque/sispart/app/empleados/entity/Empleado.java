package com.unbosque.sispart.app.empleados.entity;

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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tip_documento")
	private TipoDocumento id_tip_documento;
	@NotNull
	private Integer numDocumento;
	@NotNull
	@Column(name = "num_telefono")
	private Long numTelefono;
	@NotNull
	@Column(unique = true)
	private String correo;
	@NotNull
	private String contraseña;

	@NotNull
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")

	private Date fechaNacimiento;

	@NotNull
	private String direccion;
	@NotNull
	@Column(name = "nom_contacto_emergencia")
	private String nomContactoEmergencia;
	@NotNull
	@Column(name = "num_contacto_emergencia")
	private Long numContactoEmergencia;
	@NotNull
	private String eps;
	@NotNull
	private String arl;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Genero idGenero;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tip_sangre")
	private TipoSangre idTipoSangre;

	public Empleado() {

	}

	public Empleado(@NotNull String nombre, @NotNull String apellido, @NotNull TipoDocumento idTipoDocumento,
			@NotNull Integer numDocumento, @NotNull Long numTelefono, @NotNull String correo,
			@NotNull String contraseña, @NotNull Date fechaNacimiento, @NotNull String direccion,
			@NotNull String nomContactoEmergencia, @NotNull Long numContactoEmergencia, @NotNull String eps,
			@NotNull String arl, @NotNull Genero idGenero, @NotNull TipoSangre idTipoSangre) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.id_tip_documento = idTipoDocumento;
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

	public Empleado(Integer id, @NotNull String nombre, @NotNull String apellido,
			@NotNull TipoDocumento idTipoDocumento, @NotNull Integer numDocumento, @NotNull Long numTelefono,
			@NotNull String correo, @NotNull String contraseña, @NotNull Date fechaNacimiento,
			@NotNull String direccion, @NotNull String nomContactoEmergencia, @NotNull Long numContactoEmergencia,
			@NotNull String eps, @NotNull String arl, @NotNull Genero idGenero, @NotNull TipoSangre idTipoSangre) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.id_tip_documento = idTipoDocumento;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return id_tip_documento;
	}

	public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
		this.id_tip_documento = idTipoDocumento;
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

	private static final long serialVersionUID = 8786858584033720428L;

}
