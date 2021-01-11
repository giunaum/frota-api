package br.com.test.frota.service;

import br.com.test.frota.document.Vehicle;
import br.com.test.frota.repository.VehicleRepository;
import br.com.test.frota.service.dto.VehicleDTO;
import br.com.test.frota.service.dto.VehicleShortDatailDTO;
import br.com.test.frota.service.dto.mapper.VehicleMapper;
import br.com.test.frota.util.Constant;
import br.com.test.frota.util.MessageCode;
import br.com.test.frota.util.Utility;
import br.com.test.frota.util.exception.VehicleException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VehicleService {

	private final VehicleRepository repository;
	private final VehicleMapper mapper;

	public Page<VehicleDTO> findAll(String filter, Pageable pageable) {
		Page<Vehicle> vehicles = findVehiclesByPlateOrStatus(filter, pageable);

		if (vehicles.isEmpty()) {
			throw new VehicleException(MessageCode.VEHICLE_NOT_FOUND);
		}

		return mapper.toPageDTO(vehicles);
	}

	public VehicleDTO findById(String id) {
		return findVehicleById(id).map(mapper::toDTO)
				.orElseThrow(() -> new VehicleException(MessageCode.VEHICLE_NOT_FOUND));
	}

	public VehicleDTO create(VehicleDTO vehicle) {
		if (Objects.isNull(vehicle)) {
			throw new VehicleException(MessageCode.VEHICLE_NOT_PROVIDED);
		}

		if (StringUtils.isNotBlank(vehicle.getId()) && findVehicleById(vehicle.getId()).isPresent()) {
			throw new VehicleException(MessageCode.VEHICLE_ALREADY_EXISTS);
		}

		if (findVehicleByPlate(vehicle.getPlate()).isPresent()) {
			throw new VehicleException(MessageCode.VEHICLE_WITH_PLATE_ALREADY_EXISTS);
		}

		return save(vehicle);
	}

	public VehicleDTO update(String id, VehicleShortDatailDTO vehicle) {
		List<String> parameters = new ArrayList<>();

		if (StringUtils.isBlank(id)) {
			parameters.add(Constant.ID_VEHICLE);
		}

		if (Objects.isNull(vehicle)) {
			parameters.add(Constant.VEHICLE);
		}

		if (CollectionUtils.isNotEmpty(parameters)) {
			throw new VehicleException(MessageCode.PARAMETERS_NOT_PROVIDED, parameters);
		}

		VehicleDTO existingVehicle = findById(id);

		return save(VehicleDTO.builder()
				.id(existingVehicle.getId())
				.plate(existingVehicle.getPlate())
				.model(Optional.of(vehicle)
						.map(VehicleShortDatailDTO::getModel)
						.orElse(existingVehicle.getModel()))
				.manufacturer(Optional.of(vehicle)
						.map(VehicleShortDatailDTO::getManufacturer)
						.orElse(existingVehicle.getManufacturer()))
				.color(Optional.of(vehicle)
						.map(VehicleShortDatailDTO::getColor)
						.orElse(existingVehicle.getColor()))
				.status(Optional.of(vehicle)
						.map(VehicleShortDatailDTO::getStatus)
						.orElse(existingVehicle.getStatus()))
				.build());
	}

	public void delete(String id) {
		repository.delete(mapper.toDocument(findById(id)));
	}

	private VehicleDTO save(VehicleDTO vehicle) {
		return Optional.of(vehicle).map(mapper::toDocument).map(repository::save).map(mapper::toDTO)
				.orElseThrow(() -> new VehicleException(MessageCode.FAILED_TO_SAVE_VEHICLE));
	}

	private Optional<Vehicle> findVehicleById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new VehicleException(MessageCode.PARAMETERS_NOT_PROVIDED, Constant.ID_VEHICLE);
		}

		return repository.findById(id);
	}

	private Optional<Vehicle> findVehicleByPlate(String plate) {
		if (StringUtils.isBlank(plate)) {
			throw new VehicleException(MessageCode.PARAMETERS_NOT_PROVIDED, Constant.PLATE);
		}

		return repository.findByPlate(getPlateFormat(plate));
	}

	private Page<Vehicle> findVehiclesByPlateOrStatus(String filter, Pageable pageable) {
		String plate = getPlate(filter);
		Boolean status = getStatus(filter);

		if (StringUtils.isNotBlank(plate)) {
			return repository.findByPlate(plate, pageable);
		}

		if (Objects.nonNull(status)) {
			return repository.findByStatus(status, pageable);
		}

		return repository.findAll(pageable);
	}

	private boolean isStatus(String filter) {
		return StringUtils.isNotBlank(filter)
				&& (filter.equalsIgnoreCase(Boolean.TRUE.toString())
				|| filter.equalsIgnoreCase(Boolean.FALSE.toString()));
	}

	private Boolean getStatus(String filter) {
		return isStatus(filter) ? Boolean.parseBoolean(filter) : null;
	}

	private String getPlate(String filter) {
		return Utility.isParameter(filter) && !isStatus(filter) ? getPlateFormat(filter) : null;
	}

	private String getPlateFormat(String plate) {
		return Utility.isParameter(plate) && StringUtils.containsNone(plate, Constant.HYPHEN)
				? StringUtils.join(Utility.stringOnlyLetters(plate), Constant.HYPHEN, Utility.stringOnlyNumbers(plate))
				: plate;
	}
}
