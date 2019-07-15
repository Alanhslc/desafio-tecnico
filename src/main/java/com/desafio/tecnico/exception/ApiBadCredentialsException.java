package com.desafio.tecnico.exception;

public class ApiBadCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 5951220369607473457L;
	
	private String mensagemInterna;
	private String mensagemUsuario;
	
	public ApiBadCredentialsException(String mensagemInterna, RuntimeException e) {
		super(e);
		this.mensagemInterna = mensagemInterna;
		this.mensagemUsuario = "Erro ao autenticar API.";
	}
	
	public String getMensagemInterna() {
		return mensagemInterna;
	}
	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

}
