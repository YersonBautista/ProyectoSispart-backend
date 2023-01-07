package com.unbosque.sispart.app.comentarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.unbosque.sispart.app.comentarios.entity.Comentarios;
import com.unbosque.sispart.app.comentarios.repository.IComentariosRepository;

public class ComentarioServiceImpl implements IComentarioService {

	@Autowired
	private IComentariosRepository comentarioRepository;

	@Override
	public List<Comentarios> findAll() {

		return comentarioRepository.findAll();
	}

	@Override
	public Optional<Comentarios> getOne(int id) {

		return comentarioRepository.findById(id);
	}

	@Override
	public void save(Comentarios comentario) {

		comentarioRepository.save(comentario);
	}

	@Override
	public void delete(int id) {

		comentarioRepository.deleteById(id);
	}

	@Override
	public boolean existsById(int id) {

		return comentarioRepository.existsById(id);
	}

}
