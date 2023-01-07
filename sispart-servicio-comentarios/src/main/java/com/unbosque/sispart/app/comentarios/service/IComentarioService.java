package com.unbosque.sispart.app.comentarios.service;

import java.util.List;
import java.util.Optional;

import com.unbosque.sispart.app.comentarios.entity.Comentarios;

public interface IComentarioService {

	public List<Comentarios> findAll();

	public Optional<Comentarios> getOne(int id);

	public void save(Comentarios comentario);

	public void delete(int id);

	public boolean existsById(int id);
}
