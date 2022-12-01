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
@Table(name = "tipoSangre")
public class TipoSangre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tip_sangre")
	private Integer id;

	@NotNull
	private String tipoSangre;

	public TipoSangre() {

	}

	public TipoSangre(@NotNull String tipoSangre) {

		this.tipoSangre = tipoSangre;
	}

	public TipoSangre(Integer id, @NotNull String tipoSangre) {

		this.id = id;
		this.tipoSangre = tipoSangre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	private static final long serialVersionUID = 6652513307644902895L;

}
