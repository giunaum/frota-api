package br.com.test.frota.repository;

import br.com.test.frota.document.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

	@Query(value = "{'plate': {$regex: /^?0$/, $options: 'i'}}")
	Page<Vehicle> findByPlate(String plate, Pageable pageable);

	@Query(value = "{'plate': {$regex: /^?0$/, $options: 'i'}}")
	Optional<Vehicle> findByPlate(String plate);

	Page<Vehicle> findByStatus(boolean status, Pageable pageable);
}
