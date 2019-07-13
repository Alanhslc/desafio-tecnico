package com.desafio.tecnico.exception;

public class ApiNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String mensagemInterna;
	private String mensagemUsuario;

	public ApiNotFoundException(String mensagemInterna) {
		super(mensagemInterna);
		this.mensagemInterna = mensagemInterna;
		this.mensagemUsuario = "O recurso não foi encontrado.";
	}

	public String getMensagemInterna() {
		return mensagemInterna;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}
	
}
