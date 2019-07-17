package com.desafio.tecnico.integracao.dto;

public class ResultDTO {

	private String[] films;

	public String[] getFilms() {
		return films;
	}

	public void setFilms(String[] films) {
		this.films = films;
	}
	
	public int countFilms() {
		return this.films.length;
	}
	
}
