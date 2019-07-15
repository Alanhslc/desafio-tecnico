package com.desafio.tecnico.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.desafio.tecnico.response.ErrorResponse;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		ErrorResponse apiError = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "Erro interno.");
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler({ ApiNotFoundException.class })
	public ResponseEntity<Object> handleApiNotFound(ApiNotFoundException ex, WebRequest request) {
	    ErrorResponse apiError = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMensagemInterna(), ex.getMensagemUsuario());
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler({ ApiBadCredentialsException.class })
	public ResponseEntity<Object> handleApiBadCredentalsException(ApiBadCredentialsException ex, WebRequest request) {
		ErrorResponse apiError = new ErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMensagemInterna(), ex.getMensagemUsuario());
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
}
