package com.unbosque.sispart.app.productos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unbosque.sispart.app.productos.entity.Productos;
import com.unbosque.sispart.app.productos.repository.IProductoRepository;

@Service
@Transactional
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public List<Productos> findAll() {

		return productoRepository.findAll();
	}

	@Override
	public Optional<Productos> getOne(int id) {

		return productoRepository.findById(id);
	}

	@Override
	public Optional<Productos> getByNombre(String nombre) {

		return productoRepository.findByNombre(nombre);
	}

	@Override
	public void save(Productos producto) {

		productoRepository.save(producto);
	}

	@Override
	public void delete(int id) {

		productoRepository.deleteById(id);
	}

	@Override
	public boolean existsById(int id) {

		return productoRepository.existsById(id);
	}

	@Override
	public boolean existsByNombre(String nombre) {

		return productoRepository.existsByNombre(nombre);
	}

}
