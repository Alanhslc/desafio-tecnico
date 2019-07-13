package com.desafio.tecnico.integracao.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiDTO {

	private String[] films;

	public String[] getFilms() {
		return films;
	}

	public void setFilms(String[] films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "SwapiDTO [films=" + Arrays.toString(films) + "]";
	}
	
}
