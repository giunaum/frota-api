package br.com.test.frota.controller.error;

import br.com.test.frota.util.exception.VehicleException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerErro extends ResponseEntityExceptionHandler {

	@ExceptionHandler({VehicleException.class})
	public ResponseEntity<Object> errorVehicleResponse(VehicleException ex, WebRequest request) {
		return handleExceptionInternal(ex, getError(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	private List<String> getError(String message) {
		return Collections.singletonList(message);
	}
}
