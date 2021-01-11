package br.com.test.frota.util;

import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Objects;

/**
 * Classe Utilitária.
 */
public class Utility {

	private Utility() {
		throw new IllegalStateException("Classe utilitária! Não pode ser instanciada.");
	}

	/**
	 * Formata a {@link String} conforme os parâmetros fornecidos.
	 *
	 * @param input
	 * @param parameters
	 * @return
	 */
	public static String stringFormat(String input, String... parameters) {
		return StringUtils.isNotBlank(input) ? MessageFormat.format(input, parameters) : input;
	}

	/**
	 * Formata a {@link String} conforme os parâmetros fornecidos e com os parâmetros concatenados.
	 *
	 * @param input
	 * @param parameters
	 * @return
	 */
	public static String stringFormatJoinedParameters(String input, String... parameters) {
		return (StringUtils.isNotBlank(input) && ArrayUtils.isNotEmpty(parameters))
				? MessageFormat.format(input, String.join(", ", parameters)) : input;
	}

	/**
	 * Formata a {@link String} para retornar apenas letras..
	 *
	 * @param input
	 * @return
	 */
	public static String stringOnlyLetters(String input) {
		return input.replace(stringOnlyNumbers(input), "");
	}

	/**
	 * Formata a {@link String} para retornar apenas números..
	 *
	 * @param input
	 * @return
	 */
	public static String stringOnlyNumbers(String input) {
		return StringUtils.getDigits(input);
	}

	public static boolean isParameter(String input) {
		return StringUtils.isNotBlank(input) && !Objects.equals(input, BigInteger.ZERO.toString());
	}

	public static boolean isNotParameter(String input) {
		return !isParameter(input);
	}

	public static String toJson(Object object) {
		return new GsonBuilder().disableHtmlEscaping().create().toJson(object);
	}
}
