package com.unbosque.sispart.app.productos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unbosque.sispart.app.productos.entity.Productos;

public interface IProductoRepository extends JpaRepository<Productos, Integer> {

	Optional<Productos> findByNombre(String nombre);

	boolean existsByNombre(String nombre);

}
