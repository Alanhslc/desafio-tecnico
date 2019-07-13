package com.desafio.tecnico.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus status;
    private String mensagemInterna;
    private String mensagemUsuario;
	
    public ErrorResponse(HttpStatus status, String mensagemInterna, String mensagemUsuario) {
		this.status = status;
		this.mensagemInterna = mensagemInterna;
		this.mensagemUsuario = mensagemUsuario;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMensagemInterna() {
		return mensagemInterna;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}
	
}
