package com.unbosque.sispart.app.huespedes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unbosque.sispart.app.huespedes.entity.Huesped;

@Repository
public interface IHuespedRepository extends JpaRepository<Huesped, Integer> {

	Optional<Huesped> findByNumDocumento(int numDocumento);

	boolean existsByNumDocumento(int numDocumento);

	void deleteByNumDocumento(int numDocumento);

}
