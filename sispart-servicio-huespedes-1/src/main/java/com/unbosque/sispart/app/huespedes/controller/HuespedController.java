package com.unbosque.sispart.app.huespedes.controller;

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

import com.unbosque.sispart.app.huespedes.dto.HuespedDto;
import com.unbosque.sispart.app.huespedes.dto.Mensaje;
import com.unbosque.sispart.app.huespedes.entity.Huesped;
import com.unbosque.sispart.app.huespedes.service.IHuespedService;

@RestController
@RequestMapping("/huespedes")
public class HuespedController {

	@Autowired
	private IHuespedService huespedesService;

	@GetMapping("/listarHuespedes")
	public ResponseEntity<List<Huesped>> findAll() {
		List<Huesped> findAll = huespedesService.findAll();
		return new ResponseEntity<List<Huesped>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verHuespedes/{id}")
	public ResponseEntity<Huesped> getById(@PathVariable("id") int id) {

		if (!huespedesService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe el huesped"), HttpStatus.NOT_FOUND);

		Huesped huespedes = huespedesService.getOne(id).get();
		return new ResponseEntity<Huesped>(huespedes, HttpStatus.OK);
	}

	@GetMapping("/detalleHuesped/{numDocumento}")
	public ResponseEntity<Huesped> getByNumDocumento(@PathVariable("numDocumento") int numDocumento) {

		if (!huespedesService.existsByNumDocumento(numDocumento))

			return new ResponseEntity(new Mensaje("No existe el huesped con ese numero de documento"),
					HttpStatus.NOT_FOUND);

		Huesped huespedes = huespedesService.getByNumDocumento(numDocumento).get();
		return new ResponseEntity<Huesped>(huespedes, HttpStatus.OK);
	}

	@PostMapping("/registrarHuesped")
	public ResponseEntity<?> createHuespedes(@RequestBody HuespedDto huespedesDto) {

		if (StringUtils.isBlank(huespedesDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getApellido()))
			return new ResponseEntity(new Mensaje("El campo apellido es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getDireccion()))
			return new ResponseEntity(new Mensaje("El campo direccion es obligatorio."), HttpStatus.BAD_REQUEST);

		if (huespedesDto.getNum_celular() == null)
			return new ResponseEntity(new Mensaje("El campo numero de celular es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getCorreo()))
			return new ResponseEntity(
					new Mensaje(
							"El campo correo es obligatorio en caso de no tener correo llenar el campo con 'N/A'. "),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getId_tip_documento() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getNumDocumento() == null || huespedesDto.getNumDocumento() <= 0)
			return new ResponseEntity(new Mensaje("El campo numero de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getId_nacionalidad() == null)
			return new ResponseEntity(new Mensaje("El campo nacionalidad es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getLugar_origen()))
			return new ResponseEntity(new Mensaje("El campo lugar de origen es obligatorio."), HttpStatus.BAD_REQUEST);

		if (huespedesDto.getNum_acompañantes() == null)
			return new ResponseEntity(new Mensaje("El campo numero de acompañantes es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getDias_aprox_estadia() == null)
			return new ResponseEntity(new Mensaje("El campo dias aproximados de estadia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesService.existsByNumDocumento(huespedesDto.getNumDocumento()))
			return new ResponseEntity(new Mensaje("El huesped con el numero de documento "
					+ huespedesDto.getNumDocumento() + " ya se enecuentra registrado. "), HttpStatus.BAD_REQUEST);

		Huesped huesped = new Huesped(huespedesDto.getNombre(), huespedesDto.getApellido(), huespedesDto.getDireccion(),
				huespedesDto.getNum_celular(), huespedesDto.getCorreo(), huespedesDto.getId_tip_documento(),
				huespedesDto.getNumDocumento(), huespedesDto.getId_nacionalidad(), huespedesDto.getLugar_origen(),
				huespedesDto.getNom_contacto_emergencia(), huespedesDto.getNum_contacto_emergencia(),
				huespedesDto.getNum_acompañantes(), huespedesDto.getDias_aprox_estadia(),
				huespedesDto.getFecha_ingreso(), huespedesDto.getHora_ingreso());
		huespedesService.save(huesped);
		return new ResponseEntity(new Mensaje("El huesped ha sido registrado"), HttpStatus.OK);

	}

	@PutMapping("/actualizarHuesped/{numDocumento}")
	public ResponseEntity<?> updateHuespedes(@PathVariable("numDocumento") int numDocumento,
			@RequestBody HuespedDto huespedesDto) {

		if (!huespedesService.existsByNumDocumento(numDocumento))

			return new ResponseEntity(new Mensaje("No existe el huesped con el documento " + numDocumento),
					HttpStatus.NOT_FOUND);

		if (huespedesService.existsByNumDocumento(huespedesDto.getNumDocumento()) && huespedesService
				.getByNumDocumento(huespedesDto.getNumDocumento()).get().getNumDocumento() != numDocumento)
			return new ResponseEntity(new Mensaje(
					"No es posible actualizar el huesped con ese numero de documento, ya que existe otro huesped registrado con el mismo numero de documento"),
					HttpStatus.NOT_FOUND);

		if (StringUtils.isBlank(huespedesDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getApellido()))
			return new ResponseEntity(new Mensaje("El campo apellido es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getDireccion()))
			return new ResponseEntity(new Mensaje("El campo direccion es obligatorio."), HttpStatus.BAD_REQUEST);

		if (huespedesDto.getNum_celular() == null)
			return new ResponseEntity(new Mensaje("El campo numero de celular es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getCorreo()))
			return new ResponseEntity(
					new Mensaje(
							"El campo correo es obligatorio en caso de no tener correo llenar el campo con 'N/A'. "),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getId_tip_documento() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getNumDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo numero de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getId_nacionalidad() == null)
			return new ResponseEntity(new Mensaje("El campo nacionalidad es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getLugar_origen()))
			return new ResponseEntity(new Mensaje("El campo lugar de origen es obligatorio."), HttpStatus.BAD_REQUEST);

		if (huespedesDto.getNum_acompañantes() == null)
			return new ResponseEntity(new Mensaje("El campo numero de acompañantes es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getDias_aprox_estadia() == null)
			return new ResponseEntity(new Mensaje("El campo dias aproximados de estadia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		Huesped huesped = huespedesService.getByNumDocumento(numDocumento).get();
		huesped.setNombre(huespedesDto.getNombre());
		huesped.setApellido(huespedesDto.getApellido());
		huesped.setDireccion(huesped.getDireccion());
		huesped.setNum_celular(huespedesDto.getNum_celular());
		huesped.setCorreo(huespedesDto.getCorreo());
		huesped.setId_tip_documento(huespedesDto.getId_tip_documento());
		huesped.setNumDocumento(huespedesDto.getNumDocumento());
		huesped.setId_nacionalidad(huespedesDto.getId_nacionalidad());
		huesped.setLugar_origen(huespedesDto.getLugar_origen());
		huesped.setNom_contacto_emergencia(huespedesDto.getNom_contacto_emergencia());
		huesped.setNum_contacto_emergencia(huespedesDto.getNum_contacto_emergencia());
		huesped.setNum_acompañantes(huespedesDto.getNum_acompañantes());
		huesped.setDias_aprox_estadia(huespedesDto.getDias_aprox_estadia());
		huesped.setFecha_ingreso(huespedesDto.getFecha_ingreso());
		huesped.setHora_ingreso(huespedesDto.getHora_ingreso());

		huespedesService.save(huesped);
		return new ResponseEntity(new Mensaje(" El registro del huesped ha sido actualizado"), HttpStatus.OK);

	}

	@DeleteMapping("/deleteHuespedes/{numDocumento}")
	public ResponseEntity<?> deleteHuespedes(@PathVariable("numDocumento") int numDocumento) {
		if (!huespedesService.existsByNumDocumento(numDocumento))

			return new ResponseEntity(new Mensaje("No existe el huesped con el documento " + numDocumento),
					HttpStatus.NOT_FOUND);

		huespedesService.delete(numDocumento);
		return new ResponseEntity(new Mensaje(" El registro del huesped ha sido eliminado"), HttpStatus.OK);
	}

	/** 7 */
}
