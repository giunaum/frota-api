package br.com.test.frota.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Classe para pegar a mensagem conforme a internacionalização, mas para este projeto vai usar apenas o pt-br.
 */
public class Message {

	private static final ResourceBundle RESOURCE_MSG = ResourceBundle.getBundle("i18n/messages", new Locale("pt_br"));

	private Message() {
		throw new IllegalStateException("Classe utilitária! Não pode ser instanciada.");
	}

	/**
	 * Retorna a mensagem conforme a chave fornecida.
	 *
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		return RESOURCE_MSG.getString(key);
	}

	/**
	 * Retorna a mensagem conforme o código fornecido.
	 *
	 * @param code
	 * @return
	 */
	public static String get(MessageCode code) {
		return get(code.toString());
	}
}
