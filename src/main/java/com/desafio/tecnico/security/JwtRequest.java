package com.desafio.tecnico.security;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 8228578497941119204L;

	private String usuario;
	private String senha;
	
	public JwtRequest(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}
	
}
