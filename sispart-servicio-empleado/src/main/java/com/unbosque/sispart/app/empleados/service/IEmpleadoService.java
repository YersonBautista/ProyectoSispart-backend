package com.unbosque.sispart.app.empleados.service;

import java.util.List;
import java.util.Optional;

import com.unbosque.sispart.app.empleados.entity.Empleado;



public interface IEmpleadoService {
	
	public List<Empleado> findAll();

	public Optional<Empleado> getOne(int id);

	public Optional<Empleado> getByNumDocumento(int numDocumento);

	public void save(Empleado empleado);

	public void delete(int numDocumento);

	public boolean existsById(int id);
	
	public boolean existsByNumDocumento(int numDocumento);

}
