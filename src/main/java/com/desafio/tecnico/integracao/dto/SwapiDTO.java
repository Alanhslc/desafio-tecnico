package com.desafio.tecnico.integracao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiDTO {

	private ResultDTO[] results;

	public ResultDTO[] getResults() {
		return results;
	}

	public void setResults(ResultDTO[] results) {
		this.results = results;
	}
	
}
