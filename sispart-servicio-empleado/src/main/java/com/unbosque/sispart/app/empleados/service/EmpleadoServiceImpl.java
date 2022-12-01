package com.unbosque.sispart.app.empleados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unbosque.sispart.app.empleados.entity.Empleado;
import com.unbosque.sispart.app.empleados.repository.IEmpleadoRepository;

@Service
@Transactional
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> findAll() {

		return empleadoRepository.findAll();
	}

	@Override
	public Optional<Empleado> getOne(int id) {

		return empleadoRepository.findById(id);
	}

	@Override
	public Optional<Empleado> getByNumDocumento(int numDocumento) {

		return empleadoRepository.findByNumDocumento(numDocumento);
	}

	@Override
	public void save(Empleado empleado) {

	}

	@Override
	public void delete(int numDocumento) {

	}

	@Override
	public boolean existsById(int id) {

		return empleadoRepository.existsById(id);
	}

	@Override
	public boolean existsByNumDocumento(int numDocumento) {

		return empleadoRepository.existsByNumDocumento(numDocumento);
	}

}
