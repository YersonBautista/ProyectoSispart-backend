package com.unbosque.sispart.app.productos.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Productos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String nombre;
	@NotNull
	private Integer precio;
	@NotNull
	private Date fechaVencimiento;
	@NotNull
	private Integer prodDisponibles;

	public Productos() {

	}

	public Productos(Integer id, @NotNull String nombre, @NotNull Integer precio, @NotNull Date fechaVencimiento,
			@NotNull Integer prodDisponibles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaVencimiento = fechaVencimiento;
		this.prodDisponibles = prodDisponibles;
	}

	public Productos(@NotNull String nombre, @NotNull Integer precio, @NotNull Date fechaVencimiento,
			@NotNull Integer prodDisponibles) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.fechaVencimiento = fechaVencimiento;
		this.prodDisponibles = prodDisponibles;
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

	private static final long serialVersionUID = 1L;
}
