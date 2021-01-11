package br.com.test.frota.service;

import br.com.test.frota.document.Vehicle;
import br.com.test.frota.repository.VehicleRepository;
import br.com.test.frota.service.dto.VehicleDTO;
import br.com.test.frota.service.dto.VehicleShortDatailDTO;
import br.com.test.frota.service.dto.mapper.VehicleMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class VehicleServiceTest {

	private final static String PLATE = "ABC-1234";
	private final static String STATUS = "TRUE";

	private static final Pageable DEFAULT_PAGE_REQUEST = PageRequest
			.of(BigInteger.ZERO.intValue(), BigInteger.TEN.intValue());

	@InjectMocks
	private VehicleService service;

	@Mock
	private VehicleRepository repository;

	@Mock
	private VehicleMapper mapper;

	@Test
	void findAll() {
		Page<Vehicle> vehicles = new PageImpl<>(Collections.singletonList(mock(Vehicle.class)));

		when(repository.findAll(any(Pageable.class))).thenReturn(vehicles);
		when(repository.findByPlate(anyString(), any(Pageable.class))).thenReturn(vehicles);
		when(repository.findByStatus(anyBoolean(), any(Pageable.class))).thenReturn(vehicles);

		when(mapper.toPageDTO(any())).thenReturn(new PageImpl<>(Collections.singletonList(mock(VehicleDTO.class))));

		Page<VehicleDTO> vehiclesFindAll = service.findAll(null, DEFAULT_PAGE_REQUEST);
		assertTrue(Objects.nonNull(vehiclesFindAll) && !vehiclesFindAll.isEmpty());

		Page<VehicleDTO> vehiclesFindByPlate = service.findAll(PLATE, DEFAULT_PAGE_REQUEST);
		assertTrue(Objects.nonNull(vehiclesFindByPlate) && !vehiclesFindByPlate.isEmpty());

		Page<VehicleDTO> vehiclesFindByStatus = service.findAll(STATUS, DEFAULT_PAGE_REQUEST);
		assertTrue(Objects.nonNull(vehiclesFindByStatus) && !vehiclesFindByStatus.isEmpty());
	}

	@Test
	void findById() {
		when(repository.findById(anyString())).thenReturn(Optional.of(mock(Vehicle.class)));
		when(mapper.toDTO(any(Vehicle.class))).thenReturn(mock(VehicleDTO.class));
		assertNotNull(service.findById(BigInteger.ONE.toString()));
	}

	@Test
	void create() {
		Vehicle vehicle = mock(Vehicle.class);
		VehicleDTO vehicleDTO = mock(VehicleDTO.class);

		when(vehicleDTO.getPlate()).thenReturn(PLATE);
		when(repository.findByPlate(anyString())).thenReturn(Optional.empty());
		when(mapper.toDocument(any(VehicleDTO.class))).thenReturn(vehicle);
		when(repository.save(any(Vehicle.class))).thenReturn(vehicle);
		when(mapper.toDTO(any(Vehicle.class))).thenReturn(vehicleDTO);

		assertNotNull(service.create(vehicleDTO));
	}

	@Test
	void update() {
		Vehicle vehicle = mock(Vehicle.class);
		VehicleDTO vehicleDTO = mock(VehicleDTO.class);

		when(repository.findById(anyString())).thenReturn(Optional.of(vehicle));
		when(mapper.toDTO(any(Vehicle.class))).thenReturn(vehicleDTO);
		when(mapper.toDocument(any(VehicleDTO.class))).thenReturn(vehicle);
		when(repository.save(any(Vehicle.class))).thenReturn(vehicle);

		assertNotNull(service.update(BigInteger.ONE.toString(), mock(VehicleShortDatailDTO.class)));
	}

	@Test
	void delete() {
		Vehicle vehicle = mock(Vehicle.class);
		VehicleDTO vehicleDTO = mock(VehicleDTO.class);

		when(repository.findById(anyString())).thenReturn(Optional.of(vehicle));
		when(mapper.toDTO(any(Vehicle.class))).thenReturn(vehicleDTO);
		when(mapper.toDocument(any(VehicleDTO.class))).thenReturn(vehicle);

		assertDoesNotThrow(() -> service.delete(BigInteger.ONE.toString()));
	}
}