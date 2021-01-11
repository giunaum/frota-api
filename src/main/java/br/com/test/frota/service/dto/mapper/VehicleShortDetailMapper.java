package br.com.test.frota.service.dto.mapper;

import br.com.test.frota.document.Vehicle;
import br.com.test.frota.service.dto.VehicleDTO;
import br.com.test.frota.service.dto.VehicleShortDatailDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleShortDetailMapper implements InterfaceMapper<Vehicle, VehicleShortDatailDTO> {

	@Override
	public Vehicle toDocument(VehicleShortDatailDTO dto) {
		return Vehicle.builder()
				.model(Optional.ofNullable(dto).map(VehicleShortDatailDTO::getModel).orElse(null))
				.manufacturer(Optional.ofNullable(dto).map(VehicleShortDatailDTO::getManufacturer).orElse(null))
				.color(Optional.ofNullable(dto).map(VehicleShortDatailDTO::getColor).orElse(null))
				.status(Optional.ofNullable(dto).map(VehicleShortDatailDTO::getStatus).orElse(null))
				.build();
	}

	@Override
	public VehicleShortDatailDTO toDTO(Vehicle document) {
		return VehicleShortDatailDTO.builder()
				.model(Optional.ofNullable(document).map(Vehicle::getModel).orElse(null))
				.manufacturer(Optional.ofNullable(document).map(Vehicle::getManufacturer).orElse(null))
				.color(Optional.ofNullable(document).map(Vehicle::getColor).orElse(null))
				.status(Optional.ofNullable(document).map(Vehicle::getStatus).orElse(null))
				.build();
	}
}
