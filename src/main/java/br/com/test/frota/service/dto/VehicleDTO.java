package br.com.test.frota.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

	private String id;
	private String plate;
	private String model;
	private String manufacturer;
	private String color;
	private Boolean status;
}
