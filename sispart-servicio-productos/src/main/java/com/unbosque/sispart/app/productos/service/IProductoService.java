package com.unbosque.sispart.app.productos.service;

import java.util.List;
import java.util.Optional;

import com.unbosque.sispart.app.productos.entity.Productos;



public interface IProductoService {

	public List<Productos> findAll();

	public Optional<Productos> getOne(int id);

	public Optional<Productos> getByNombre(String nombre);

	public void save(Productos producto);

	public void delete(int id);

	public boolean existsById(int id);

	public boolean existsByNombre(String nombre);
}
