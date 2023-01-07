package com.unbosque.sispart.app.productos.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unbosque.sispart.app.productos.dto.Mensaje;
import com.unbosque.sispart.app.productos.dto.ProductosDto;
import com.unbosque.sispart.app.productos.entity.Productos;
import com.unbosque.sispart.app.productos.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	@GetMapping("/listarProductos")
	public ResponseEntity<List<Productos>> findAll() {
		List<Productos> findAll = productoService.findAll();
		return new ResponseEntity<List<Productos>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verProducto/{id}")
	public ResponseEntity<Productos> getById(@PathVariable("id") int id) {

		if (!productoService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe el producto"), HttpStatus.NOT_FOUND);
		Productos producto = productoService.getOne(id).get();

		return new ResponseEntity<Productos>(producto, HttpStatus.OK);
	}

	@PostMapping("/registrarProducto")
	public ResponseEntity<?> createNacionalidades(@RequestBody ProductosDto productoDto) {

		if (StringUtils.isBlank(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (productoDto.getPrecio() == null || productoDto.getPrecio() < 0)
			return new ResponseEntity(new Mensaje("El campo precio es obligatorio y no puede ser menor que cero (0)."),
					HttpStatus.BAD_REQUEST);

		if (productoService.existsByNombre(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El producto que intenta ingresar ya se encuentra registrado."),
					HttpStatus.BAD_REQUEST);

		if (productoDto.getFechaVencimiento() == null)
			return new ResponseEntity(new Mensaje("El campo fecha de vencimiento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (productoDto.getProdDisponibles() == null || productoDto.getPrecio() < 0)
			return new ResponseEntity(
					new Mensaje("El campo de productos disponibles es obligatorio y no puede ser menor que cero (0)."),
					HttpStatus.BAD_REQUEST);

		Productos productos = new Productos(productoDto.getNombre(), productoDto.getPrecio(),
				productoDto.getFechaVencimiento(), productoDto.getProdDisponibles());
		productoService.save(productos);
		return new ResponseEntity(new Mensaje("El producto ha sido registrado"), HttpStatus.OK);

	}

	@PutMapping("/actualizarProducto/{id}")
	public ResponseEntity<?> updateNacionalidades(@PathVariable("id") int id, @RequestBody ProductosDto productoDto) {

		if (!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe el producto que desea actualizar"), HttpStatus.NOT_FOUND);

		if (productoService.existsByNombre(productoDto.getNombre())
				&& productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
			return new ResponseEntity(new Mensaje(
					"No es posible actualizar el producto con ese nombre, ya que existe otro registro con el mismo nombre"),
					HttpStatus.NOT_FOUND);

		if (StringUtils.isBlank(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (productoDto.getPrecio() == null || productoDto.getPrecio() < 0)
			return new ResponseEntity(new Mensaje("El campo precio es obligatorio y no puede ser menor que cero (0)."),
					HttpStatus.BAD_REQUEST);

		if (productoService.existsByNombre(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El producto que intenta ingresar ya se encuentra registrado."),
					HttpStatus.BAD_REQUEST);

		if (productoDto.getFechaVencimiento() == null)
			return new ResponseEntity(new Mensaje("El campo fecha de vencimiento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (productoDto.getProdDisponibles() == null || productoDto.getPrecio() < 0)
			return new ResponseEntity(
					new Mensaje("El campo de productos disponibles es obligatorio y no puede ser menor que cero (0)."),
					HttpStatus.BAD_REQUEST);

		Productos productos = productoService.getOne(id).get();
		productos.setNombre(productoDto.getNombre());
		productoService.save(productos);

		return new ResponseEntity(new Mensaje("La nacionalidad ha sido actualizada"), HttpStatus.OK);

	}

	@DeleteMapping("/deleteProducto/{id}")
	public ResponseEntity<?> deleteHuespedes(@PathVariable("id") int id) {
		if (!productoService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe el producto que desea eliminar "), HttpStatus.NOT_FOUND);

		productoService.delete(id);
		return new ResponseEntity(new Mensaje(" El producto ha sido eliminado "), HttpStatus.OK);
	}

}
