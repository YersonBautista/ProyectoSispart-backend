package com.unbosque.sispart.app.comentarios.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class ComentarioDto {

	@NotBlank
	private String autor;
	@NotBlank
	private String comentario;
	@NotBlank
	private Date fechaHora;

	public ComentarioDto() {

	}

	public ComentarioDto(@NotBlank String autor, @NotBlank String comentario, @NotBlank Date fechaHora) {
		super();
		this.autor = autor;
		this.comentario = comentario;
		this.fechaHora = fechaHora;
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

}
