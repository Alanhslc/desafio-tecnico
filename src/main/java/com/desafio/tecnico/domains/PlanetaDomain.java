package com.desafio.tecnico.domains;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection = "planeta")
public class PlanetaDomain {

	@Id
	private ObjectId _id;
	
	private String nome;
	
	private String clima;
	
	private String terreno;
	
	@Transient
	@JsonSerialize
	private Integer aparicoesEmFilme = 0;

	public String get_id() { 
		return _id.toHexString(); 
	}

	public void set_id(ObjectId _id) { 
		this._id = _id; 
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
