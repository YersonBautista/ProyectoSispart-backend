package com.unbosque.sispart.app.empleados.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unbosque.sispart.app.empleados.dto.EmpleadoDto;
import com.unbosque.sispart.app.empleados.dto.Mensaje;
import com.unbosque.sispart.app.empleados.entity.Empleado;
import com.unbosque.sispart.app.empleados.service.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;

	@GetMapping("/listarEmpleados")
	public ResponseEntity<List<Empleado>> findAll() {
		List<Empleado> findAll = empleadoService.findAll();
		return new ResponseEntity<List<Empleado>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verEmpleado/{id}")
	public ResponseEntity<Empleado> getById(@PathVariable("id") int id) {

		if (!empleadoService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe el empleado con ese id "), HttpStatus.NOT_FOUND);

		Empleado empleado = empleadoService.getOne(id).get();
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);

	}

	@GetMapping("/detalleEmpleado/{numDocumento}")
	public ResponseEntity<Empleado> getByNumDocumento(@PathVariable("numDocumento") int numDocumento) {

		if (!empleadoService.existsByNumDocumento(numDocumento))
			return new ResponseEntity(new Mensaje("No existe el empleado con el numero de documento " + numDocumento),
					HttpStatus.NOT_FOUND);

		Empleado empleado = empleadoService.getByNumDocumento(numDocumento).get();
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);

	}

	@PostMapping("/registrarEmpleado")
	public ResponseEntity<?> createEmpleado(@RequestBody EmpleadoDto empleadoDto) {

		if (StringUtils.isBlank(empleadoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getApellido()))
			return new ResponseEntity(new Mensaje("El campo apellido es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdTipoDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo numero de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumTelefono() == null)
			return new ResponseEntity(new Mensaje("El campo numero de telefono es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getCorreo()))
			return new ResponseEntity(new Mensaje("El campo correo es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getContraseña()))
			return new ResponseEntity(new Mensaje("El campo contraseña es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getFechaNacimiento() == null)
			return new ResponseEntity(new Mensaje("El campo fecha nacimiento es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getDireccion()))
			return new ResponseEntity(new Mensaje("El campo direccion es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getNomContactoEmergencia()))
			return new ResponseEntity(new Mensaje("El campo nombre contacto de emergencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumContactoEmergencia() == null)
			return new ResponseEntity(new Mensaje("El campo numero contacto de emergencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getEps()))
			return new ResponseEntity(new Mensaje("El campo eps es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getArl()))
			return new ResponseEntity(new Mensaje("El campo arl es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdGenero() == null)
			return new ResponseEntity(new Mensaje("El campo genero es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdTipoSangre() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de sangre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoService.existsByNumDocumento(empleadoDto.getNumDocumento()))
			return new ResponseEntity(new Mensaje("El empleado con el numero de documento "
					+ empleadoDto.getNumDocumento() + " ya se enecuentra registrado. "), HttpStatus.BAD_REQUEST);

		Empleado empleado = new Empleado(empleadoDto.getNombre(), empleadoDto.getApellido(),
				empleadoDto.getIdTipoDocumento(), empleadoDto.getNumDocumento(), empleadoDto.getNumTelefono(),
				empleadoDto.getCorreo(), empleadoDto.getContraseña(), empleadoDto.getFechaNacimiento(),
				empleadoDto.getDireccion(), empleadoDto.getNomContactoEmergencia(),
				empleadoDto.getNumContactoEmergencia(), empleadoDto.getEps(), empleadoDto.getArl(),
				empleadoDto.getIdGenero(), empleadoDto.getIdTipoSangre());

		empleadoService.save(empleado);
		return new ResponseEntity(new Mensaje("El empleado ha sido registrado"), HttpStatus.OK);

	}

	@PostMapping("/actualizarEmpleado/{numDocumento}")
	public ResponseEntity<?> updateEmpleado(@PathVariable("numDocumento") int numDocumento,
			@RequestBody EmpleadoDto empleadoDto) {

		if (!empleadoService.existsByNumDocumento(empleadoDto.getNumDocumento()))
			return new ResponseEntity(
					new Mensaje("No existe el empleado con el numero de documento " + empleadoDto.getNumDocumento()),
					HttpStatus.NOT_FOUND);

		if (empleadoService.existsByNumDocumento(empleadoDto.getNumDocumento()) && empleadoService
				.getByNumDocumento(empleadoDto.getNumDocumento()).get().getNumDocumento() != numDocumento)
			return new ResponseEntity(
					new Mensaje("No es posible actualizar, el empleado con el numero de documento "
							+ empleadoDto.getNumDocumento() + " ya se encuentra registrado en otro empleado. "),
					HttpStatus.NOT_FOUND);

		if (StringUtils.isBlank(empleadoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getApellido()))
			return new ResponseEntity(new Mensaje("El campo apellido es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdTipoDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo numero de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumTelefono() == null)
			return new ResponseEntity(new Mensaje("El campo numero de telefono es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getCorreo()))
			return new ResponseEntity(new Mensaje("El campo correo es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getContraseña()))
			return new ResponseEntity(new Mensaje("El campo contraseña es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getFechaNacimiento() == null)
			return new ResponseEntity(new Mensaje("El campo fecha nacimiento es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getDireccion()))
			return new ResponseEntity(new Mensaje("El campo direccion es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getNomContactoEmergencia()))
			return new ResponseEntity(new Mensaje("El campo nombre contacto de emergencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumContactoEmergencia() == null)
			return new ResponseEntity(new Mensaje("El campo numero contacto de emergencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getEps()))
			return new ResponseEntity(new Mensaje("El campo eps es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getArl()))
			return new ResponseEntity(new Mensaje("El campo arl es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdGenero() == null)
			return new ResponseEntity(new Mensaje("El campo genero es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdTipoSangre() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de sangre es obligatorio."), HttpStatus.BAD_REQUEST);

		Empleado empleado = empleadoService.getByNumDocumento(numDocumento).get();
		empleado.setNombre(empleadoDto.getNombre());
		empleado.setApellido(empleadoDto.getApellido());
		empleado.setIdTipoDocumento(empleadoDto.getIdTipoDocumento());
		empleado.setNumDocumento(empleadoDto.getNumDocumento());
		empleado.setNumTelefono(empleadoDto.getNumTelefono());
		empleado.setCorreo(empleadoDto.getCorreo());
		empleado.setContraseña(empleadoDto.getContraseña());
		empleado.setDireccion(empleadoDto.getDireccion());
		empleado.setNomContactoEmergencia(empleadoDto.getNomContactoEmergencia());
		empleado.setNumContactoEmergencia(empleadoDto.getNumContactoEmergencia());
		empleado.setEps(empleadoDto.getEps());
		empleado.setArl(empleadoDto.getArl());
		empleado.setIdGenero(empleadoDto.getIdGenero());

		empleadoService.save(empleado);
		return new ResponseEntity(new Mensaje("Los datos del empleado han sido actualizados"), HttpStatus.OK);

	}

	@DeleteMapping("/deleteEmpleado/{numDocumento}")
	public ResponseEntity<?> deleteEmpleados(@PathVariable("numDocumento") int numDocumento) {
		if (!empleadoService.existsByNumDocumento(numDocumento))

			return new ResponseEntity(new Mensaje("No existe el huesped con el documento " + numDocumento),
					HttpStatus.NOT_FOUND);

		empleadoService.delete(numDocumento);
		return new ResponseEntity(new Mensaje(" El registro del huesped ha sido eliminado"), HttpStatus.OK);
	}

}
