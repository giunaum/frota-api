package br.com.test.frota.controller;

import br.com.test.frota.service.VehicleService;
import br.com.test.frota.service.dto.VehicleDTO;
import br.com.test.frota.service.dto.VehicleShortDatailDTO;
import br.com.test.frota.util.Message;
import br.com.test.frota.util.MessageCode;
import br.com.test.frota.util.Utility;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/vehicle")
@Api(value = "Api Rest Vehicle")
public class VehicleController {

	private final VehicleService service;

	@GetMapping
	@ApiOperation(value = "Recuperar os veículos")
	public ResponseEntity<Page<VehicleDTO>> getVehicles(@RequestParam(required = false) String filter,
														@PageableDefault Pageable pageable) {
		return new ResponseEntity<>(service.findAll(filter, pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Recuperar um veículo por ID")
	public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable String id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "Cadastrar um veículo")
	public ResponseEntity<VehicleDTO> saveVehicle(@RequestBody VehicleDTO vehicle) {
		return new ResponseEntity<>(service.create(vehicle), HttpStatus.CREATED);
	}

	@PatchMapping(path = "/{id}")
	@ApiOperation(value = "Atualizar dados do veículo")
	public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable String id,
													@RequestBody VehicleShortDatailDTO vehicle) {
		return new ResponseEntity<>(service.update(id, vehicle), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	@ApiOperation(value = "Excluir um veículo")
	public ResponseEntity<Object> deleteVehicle(@PathVariable String id) {
		service.delete(id);
		return new ResponseEntity<>(Utility.toJson(Message.get(MessageCode.VEHICLE_DELETED)), HttpStatus.OK);
	}
}
