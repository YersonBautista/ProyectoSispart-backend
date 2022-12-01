package com.unbosque.sispart.app.empleados.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unbosque.sispart.app.empleados.entity.TipoDocumento;



@Repository
public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {

	Optional<TipoDocumento> findByTipDocumento(String tipDocumento);
	boolean existsByTipDocumento(String tipDocumento);
}
