package br.com.test.frota.util.exception;

import br.com.test.frota.util.MessageCode;

import java.util.List;

public class VehicleException extends CustomException {

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param message
	 * @param cause
	 */
	public VehicleException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param message
	 * @param cause
	 */
	public VehicleException(Class<?> loggerClass, String message, Throwable cause) {
		super(loggerClass, message, cause);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param message
	 */
	public VehicleException(String message) {
		super(message);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param message
	 */
	public VehicleException(Class<?> loggerClass, String message) {
		super(loggerClass, message);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param code
	 */
	public VehicleException(MessageCode code) {
		super(code);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param code
	 */
	public VehicleException(Class<?> loggerClass, MessageCode code) {
		super(loggerClass, code);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param message
	 * @param parameters
	 */
	public VehicleException(String message, List<String> parameters) {
		super(message, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param message
	 * @param parameters
	 */
	public VehicleException(Class<?> loggerClass, String message, List<String> parameters) {
		super(loggerClass, message, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param message
	 * @param parameters
	 */
	public VehicleException(String message, String... parameters) {
		super(message, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param message
	 * @param parameters
	 */
	public VehicleException(Class<?> loggerClass, String message, String... parameters) {
		super(loggerClass, message, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param code
	 * @param parameters
	 */
	public VehicleException(MessageCode code, List<String> parameters) {
		super(code, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param code
	 * @param parameters
	 */
	public VehicleException(Class<?> loggerClass, MessageCode code, List<String> parameters) {
		super(loggerClass, code, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param code
	 * @param parameters
	 */
	public VehicleException(MessageCode code, String... parameters) {
		super(code, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param code
	 * @param parameters
	 */
	public VehicleException(Class<?> loggerClass, MessageCode code, String... parameters) {
		super(loggerClass, code, parameters);
	}
}
