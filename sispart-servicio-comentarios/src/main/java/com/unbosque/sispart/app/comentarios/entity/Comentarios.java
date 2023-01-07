package com.unbosque.sispart.app.comentarios.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comentarios")
public class Comentarios implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comentario")
	private Integer id;

	@NotNull
	private String autor;
	@NotNull
	private String comentario;
	@NotNull
	@Column(name = "fecha_Hora")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;

	public Comentarios() {

	}

	public Comentarios(@NotNull String autor, @NotNull String comentario, @NotNull Date fechaHora) {
		this.autor = autor;
		this.comentario = comentario;
		this.fechaHora = fechaHora;
	}

	public Comentarios(Integer id, @NotNull String autor, @NotNull String comentario, @NotNull Date fechaHora) {
		this.id = id;
		this.autor = autor;
		this.comentario = comentario;
		this.fechaHora = fechaHora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	private static final long serialVersionUID = -8231162565367996191L;

}
