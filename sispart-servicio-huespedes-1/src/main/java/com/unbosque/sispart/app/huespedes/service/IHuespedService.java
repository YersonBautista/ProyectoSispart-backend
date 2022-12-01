package com.unbosque.sispart.app.huespedes.service;

import java.util.List;
import java.util.Optional;

import com.unbosque.sispart.app.huespedes.entity.Huesped;

public interface IHuespedService {

	public List<Huesped> findAll();

	public Optional<Huesped> getOne(int id);

	public Optional<Huesped> getByNumDocumento(int numDocumento);

	public void save(Huesped huesped);

	public void delete(int numDocumento);

	public boolean existsById(int id);
	
	public boolean existsByNumDocumento(int numDocumento);

}
