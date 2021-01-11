package br.com.test.frota.util;

/**
 * Enum com os código de exceções/mensagens.
 */
public enum MessageCode {

	VEHICLE_NOT_FOUND("vehicle_not_found"),
	VEHICLE_NOT_PROVIDED("vehicle_not_provided"),
	PARAMETERS_NOT_PROVIDED("parameters_not_provided"),
	FAILED_TO_SAVE_VEHICLE("failed_to_save_vehicle"),
	VEHICLE_ALREADY_EXISTS("vehicle_already_exists"),
	VEHICLE_WITH_PLATE_ALREADY_EXISTS("vehicle_with_plate_already_exists"),
	VEHICLE_DELETED("vehicle_deleted");

	private final String key;

	/**
	 * Construtor do Enum.
	 *
	 * @param key
	 */
	MessageCode(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return key;
	}
}
