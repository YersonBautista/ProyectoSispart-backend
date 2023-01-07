package com.unbosque.sispart.app.comentarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unbosque.sispart.app.comentarios.entity.Comentarios;

public interface IComentariosRepository extends JpaRepository<Comentarios, Integer> {

}
