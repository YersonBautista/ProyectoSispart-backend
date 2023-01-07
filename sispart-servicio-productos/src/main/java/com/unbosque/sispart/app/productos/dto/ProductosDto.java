package com.unbosque.sispart.app.productos.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductosDto {

	@NotBlank
	private String nombre;
	@NotBlank
	private Integer precio;
	@NotBlank
	private Date fechaVencimiento;
	@NotBlank
	private Integer prodDisponibles;

	public ProductosDto() {

	}

	public ProductosDto(@NotBlank String nombre, @NotBlank Integer precio, @NotBlank Date fechaVencimiento,
			@NotBlank Integer prodDisponibles) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.fechaVencimiento = fechaVencimiento;
		this.prodDisponibles = prodDisponibles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Integer getProdDisponibles() {
		return prodDisponibles;
	}

	public void setProdDisponibles(Integer prodDisponibles) {
		this.prodDisponibles = prodDisponibles;
	}

}
