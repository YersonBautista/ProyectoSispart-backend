package com.unbosque.sispart.app.huespedes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.unbosque.sispart.app.huespedes.entity.Huesped;
import com.unbosque.sispart.app.huespedes.repository.IHuespedRepository;

@Service
@Transactional
public class HuespedServiceImpl implements IHuespedService {
	
	@Autowired
	private IHuespedRepository huespedRepository;

	
	@Transactional(readOnly = true)
	@Override
	public List<Huesped> findAll() {

		return huespedRepository.findAll();
	}

	@Override
	public Optional<Huesped> getOne(int id) {

		return huespedRepository.findById(id);
	}
	
	@Override
	public Optional<Huesped> getByNumDocumento(int numDocumento) {
		
		return huespedRepository.findByNumDocumento(numDocumento);
	}
	
	@Override
	public void save(Huesped huesped) {
		
		huespedRepository.save(huesped);

	}

	@Override
	public void delete(int numDocumento) {
		
		huespedRepository.deleteByNumDocumento(numDocumento);
	}

	@Override
	public boolean existsById(int id) {
		
		return huespedRepository.existsById(id);
	}

	@Override
	public boolean existsByNumDocumento(int numDocumento) {
		
		return huespedRepository.existsByNumDocumento(numDocumento);
	}

}
