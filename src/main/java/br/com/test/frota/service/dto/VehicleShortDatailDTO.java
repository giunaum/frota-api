package br.com.test.frota.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleShortDatailDTO {

	private String model;
	private String manufacturer;
	private String color;
	private Boolean status;
}
