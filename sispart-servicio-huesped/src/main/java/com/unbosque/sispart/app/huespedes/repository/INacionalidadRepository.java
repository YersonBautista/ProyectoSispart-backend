package com.unbosque.sispart.app.huespedes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unbosque.sispart.app.huespedes.entity.Nacionalidad;

public interface INacionalidadRepository extends JpaRepository<Nacionalidad, Integer> {

	Optional<Nacionalidad> findByNombre(String nombre);

	boolean existsByNombre(String nombre);

}
