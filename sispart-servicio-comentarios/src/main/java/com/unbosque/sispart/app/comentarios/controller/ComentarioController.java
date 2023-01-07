package com.unbosque.sispart.app.comentarios.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unbosque.sispart.app.comentarios.dto.ComentarioDto;
import com.unbosque.sispart.app.comentarios.dto.Mensaje;
import com.unbosque.sispart.app.comentarios.entity.Comentarios;
import com.unbosque.sispart.app.comentarios.service.IComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

	private IComentarioService comentarioService;

	@GetMapping("/listarComentarios")
	public ResponseEntity<List<Comentarios>> findAll() {
		List<Comentarios> findAll = comentarioService.findAll();
		return new ResponseEntity<List<Comentarios>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verComentario/{id}")
	public ResponseEntity<Comentarios> getById(@PathVariable("id") int id) {

		if (!comentarioService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe el empleado con ese id "), HttpStatus.NOT_FOUND);

		Comentarios comentarios = comentarioService.getOne(id).get();
		return new ResponseEntity<Comentarios>(comentarios, HttpStatus.OK);

	}

	@PostMapping("/añadirComentario")
	public ResponseEntity<?> createComentario(@RequestBody ComentarioDto comentarioDto) {

		if (StringUtils.isBlank(comentarioDto.getAutor()))
			return new ResponseEntity(new Mensaje("Por favor ingresar el nombre es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(comentarioDto.getComentario()))
			return new ResponseEntity(new Mensaje("Por favor ingrese un comentario  es obligatorio."),
					HttpStatus.BAD_REQUEST);

		Comentarios comentario = new Comentarios(comentarioDto.getAutor(), comentarioDto.getComentario(),
				comentarioDto.getFechaHora());

		comentarioService.save(comentario);

		return new ResponseEntity(new Mensaje("Su comentario ha sido agregado"), HttpStatus.OK);
	}

	@PostMapping("/actualizarComentario/{id}")
	public ResponseEntity<?> updateComentario(@PathVariable("id") int id, @RequestBody ComentarioDto comentarioDto) {

		if (StringUtils.isBlank(comentarioDto.getAutor()))
			return new ResponseEntity(new Mensaje("Por favor ingresar el nombre es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(comentarioDto.getComentario()))
			return new ResponseEntity(new Mensaje("Por favor ingrese un comentario  es obligatorio."),
					HttpStatus.BAD_REQUEST);

		Comentarios comentario = comentarioService.getOne(id).get();
		comentario.setAutor(comentarioDto.getAutor());
		comentario.setComentario(comentarioDto.getComentario());

		comentarioService.save(comentario);
		return new ResponseEntity(new Mensaje("Su comentario ha sido actualizado"), HttpStatus.OK);
	}

	@DeleteMapping("/deleteComentario/{id}")
	public ResponseEntity<?> deleteEmpleados(@PathVariable("id") int id) {

		if (!comentarioService.existsById(id))

			return new ResponseEntity(new Mensaje("No es posible eliminar el comentario "), HttpStatus.NOT_FOUND);

		comentarioService.delete(id);
		return new ResponseEntity(new Mensaje("El comentario ha sido eliminado"), HttpStatus.OK);

	}
}
