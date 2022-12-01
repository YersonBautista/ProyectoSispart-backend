package com.unbosque.sispart.app.huespedes.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tip_documento;
	@NotNull
	private String tipDocumento;

	
	public TipoDocumento() {
		
	}


	public TipoDocumento(int id_tip_documento, String tipDocumento) {

		this.id_tip_documento = id_tip_documento;
		this.tipDocumento = tipDocumento;
	}


	public TipoDocumento(String tipDocumento) {
	
		this.tipDocumento = tipDocumento;
	}


	public int getId_tip_documento() {
		return id_tip_documento;
	}


	public void setId_tip_documento(int id_tip_documento) {
		this.id_tip_documento = id_tip_documento;
	}


	public String getTipDocumento() {
		return tipDocumento;
	}


	public void setTipDocumento(String tipDocumento) {
		this.tipDocumento = tipDocumento;
	}
	
	
	
	private static final long serialVersionUID = 1L;
	

}
