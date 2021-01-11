package br.com.test.frota.util.exception;

import br.com.test.frota.util.Message;
import br.com.test.frota.util.MessageCode;
import br.com.test.frota.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * Classe de exceção customizada.
 */
public class CustomException extends RuntimeException implements Serializable {

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param message
	 * @param cause
	 */
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param message
	 * @param cause
	 */
	public CustomException(Class<?> loggerClass, String message, Throwable cause) {
		super(message, cause);
		logger(loggerClass, message, cause);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param message
	 */
	public CustomException(String message) {
		super(message);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param message
	 */
	public CustomException(Class<?> loggerClass, String message) {
		super(message);
		logger(loggerClass, message);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param code
	 */
	public CustomException(MessageCode code) {
		super(Message.get(code));
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param code
	 */
	public CustomException(Class<?> loggerClass, MessageCode code) {
		super(Message.get(code));
		logger(loggerClass, code);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param message
	 * @param parameters
	 */
	public CustomException(String message, List<String> parameters) {
		super(Utility.stringFormatJoinedParameters(message, parameters.toArray(new String[BigInteger.ZERO.intValue()])));
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param message
	 * @param parameters
	 */
	public CustomException(Class<?> loggerClass, String message, List<String> parameters) {
		super(Utility.stringFormatJoinedParameters(message, parameters.toArray(new String[BigInteger.ZERO.intValue()])));
		logger(loggerClass, message, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param message
	 * @param parameters
	 */
	public CustomException(String message, String... parameters) {
		super(Utility.stringFormatJoinedParameters(message, parameters));
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param message
	 * @param parameters
	 */
	public CustomException(Class<?> loggerClass, String message, String... parameters) {
		super(Utility.stringFormatJoinedParameters(message, parameters));
		logger(loggerClass, message, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param code
	 * @param parameters
	 */
	public CustomException(MessageCode code, List<String> parameters) {
		super(Utility.stringFormatJoinedParameters(Message.get(code), parameters.toArray(new String[BigInteger.ZERO.intValue()])));
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param code
	 * @param parameters
	 */
	public CustomException(Class<?> loggerClass, MessageCode code, List<String> parameters) {
		super(Utility.stringFormatJoinedParameters(Message.get(code), parameters.toArray(new String[BigInteger.ZERO.intValue()])));
		logger(loggerClass, code, parameters);
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param code
	 * @param parameters
	 */
	public CustomException(MessageCode code, String... parameters) {
		super(Utility.stringFormatJoinedParameters(Message.get(code), parameters));
	}

	/**
	 * Construtor da classe de exceção.
	 *
	 * @param loggerClass
	 * @param code
	 * @param parameters
	 */
	public CustomException(Class<?> loggerClass, MessageCode code, String... parameters) {
		super(Utility.stringFormatJoinedParameters(Message.get(code), parameters));
		logger(loggerClass, code, parameters);
	}

	/**
	 * Insere a mensagem no logger.
	 *
	 * @param loggerClass
	 * @param message
	 */
	protected void logger(Class<?> loggerClass, String message) {
		Logger logger = LoggerFactory.getLogger(loggerClass);
		logger.warn(message);
	}

	/**
	 * Insere a mensagem no logger.
	 *
	 * @param loggerClass
	 * @param message
	 * @param parameters
	 */
	protected void logger(Class<?> loggerClass, String message, List<String> parameters) {
		logger(loggerClass, Utility.stringFormatJoinedParameters(message, parameters.toArray(new String[BigInteger.ZERO.intValue()])));
	}

	/**
	 * Insere a mensagem no logger.
	 *
	 * @param loggerClass
	 * @param code
	 * @param parameters
	 */
	protected void logger(Class<?> loggerClass, MessageCode code, List<String> parameters) {
		logger(loggerClass, Utility.stringFormatJoinedParameters(Message.get(code), parameters.toArray(new String[BigInteger.ZERO.intValue()])));
	}

	/**
	 * Insere a mensagem no logger.
	 *
	 * @param loggerClass
	 * @param message
	 * @param parameters
	 */
	protected void logger(Class<?> loggerClass, String message, String... parameters) {
		logger(loggerClass, Utility.stringFormatJoinedParameters(message, parameters));
	}

	/**
	 * Insere a mensagem no logger.
	 *
	 * @param loggerClass
	 * @param code
	 * @param parameters
	 */
	protected void logger(Class<?> loggerClass, MessageCode code, String... parameters) {
		logger(loggerClass, Utility.stringFormatJoinedParameters(Message.get(code), parameters));
	}

	/**
	 * Insere a mensagem no logger.
	 *
	 * @param loggerClass
	 * @param code
	 */
	protected void logger(Class<?> loggerClass, MessageCode code) {
		logger(loggerClass, Message.get(code));
	}

	/**
	 * Insere a mensagem no logger.
	 *
	 * @param loggerClass
	 * @param message
	 * @param cause
	 */
	protected void logger(Class<?> loggerClass, String message, Throwable cause) {
		Logger logger = LoggerFactory.getLogger(loggerClass);
		logger.error(message, cause);
	}
}
