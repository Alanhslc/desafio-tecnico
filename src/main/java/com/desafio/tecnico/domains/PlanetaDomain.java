package com.desafio.tecnico.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planeta")
public class PlanetaDomain {

	@Id
	private Integer id;
	
	private String nome;
	
	private String clima;
	
	private String terreno;
	
	private Integer aparicoesEmFilme = 0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getAparicoesEmFilme() {
		return aparicoesEmFilme;
	}

	public void setAparicoesEmFilme(Integer aparicoesEmFilme) {
		this.aparicoesEmFilme = aparicoesEmFilme;
	}

}
