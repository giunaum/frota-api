package br.com.test.frota.service.dto.mapper;

import br.com.test.frota.document.Vehicle;
import br.com.test.frota.service.dto.VehicleDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleMapper implements InterfaceMapper<Vehicle, VehicleDTO> {

	@Override
	public Vehicle toDocument(VehicleDTO dto) {
		return Vehicle.builder()
				.id(Optional.ofNullable(dto).map(VehicleDTO::getId).orElse(null))
				.plate(Optional.ofNullable(dto).map(VehicleDTO::getPlate).orElse(null))
				.model(Optional.ofNullable(dto).map(VehicleDTO::getModel).orElse(null))
				.manufacturer(Optional.ofNullable(dto).map(VehicleDTO::getManufacturer).orElse(null))
				.color(Optional.ofNullable(dto).map(VehicleDTO::getColor).orElse(null))
				.status(Optional.ofNullable(dto).map(VehicleDTO::getStatus).orElse(null))
				.build();
	}

	@Override
	public VehicleDTO toDTO(Vehicle document) {
		return VehicleDTO.builder()
				.id(Optional.ofNullable(document).map(Vehicle::getId).orElse(null))
				.plate(Optional.ofNullable(document).map(Vehicle::getPlate).orElse(null))
				.model(Optional.ofNullable(document).map(Vehicle::getModel).orElse(null))
				.manufacturer(Optional.ofNullable(document).map(Vehicle::getManufacturer).orElse(null))
				.color(Optional.ofNullable(document).map(Vehicle::getColor).orElse(null))
				.status(Optional.ofNullable(document).map(Vehicle::getStatus).orElse(null))
				.build();
	}
}
