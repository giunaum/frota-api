package br.com.test.frota.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Vehicle {

	@Id
	private String id;

	private String plate;
	private String model;
	private String manufacturer;
	private String color;
	private Boolean status;
}
