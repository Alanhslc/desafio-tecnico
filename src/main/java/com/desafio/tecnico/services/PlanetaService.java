package com.desafio.tecnico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.tecnico.domains.PlanetaDomain;
import com.desafio.tecnico.exception.ApiNotFoundException;
import com.desafio.tecnico.repositories.PlanetaRepository;

@Service
public class PlanetaService {

	private static final String OBJETO_NÃO_ENCONTRADO_NA_BASE_DE_DADOS = "Objeto não encontrado na base de dados.";
	
	@Autowired
	private PlanetaRepository repository;
	
	public PlanetaDomain obterPor(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ApiNotFoundException(OBJETO_NÃO_ENCONTRADO_NA_BASE_DE_DADOS));
	}
	
	public PlanetaDomain obterPor(String nome) {
		return repository.findByName(nome)
				.orElseThrow(() -> new ApiNotFoundException(OBJETO_NÃO_ENCONTRADO_NA_BASE_DE_DADOS));
	}
	
	public List<PlanetaDomain> obterTodos() {
		return repository.findAll();
	}
	
	public void removerPor(Integer id) {
		repository.deleteById(id);
	}
	
	public PlanetaDomain inserirPor(PlanetaDomain planeta) {
		return repository.save(planeta);
	}
	
}
