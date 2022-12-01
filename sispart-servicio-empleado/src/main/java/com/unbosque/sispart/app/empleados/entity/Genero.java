package com.unbosque.sispart.app.empleados.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "genero")
public class Genero implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genero")
	private Integer id;

	@NotNull
	private String genero;

	public Genero() {

	}

	public Genero(@NotNull String genero) {

		this.genero = genero;
	}

	public Genero(Integer id, @NotNull String genero) {

		this.id = id;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	private static final long serialVersionUID = 3909671778259252550L;
}
