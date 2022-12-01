package com.unbosque.sispart.app.empleados.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unbosque.sispart.app.empleados.entity.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

	Optional<Empleado> findByNumDocumento(int numDocumento);

	boolean existsByNumDocumento(int numDocumento);

	void deleteByNumDocumento(int numDocumento);

}
