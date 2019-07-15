package com.desafio.tecnico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.tecnico.domains.PlanetaDomain;
import com.desafio.tecnico.exception.ApiNotFoundException;
import com.desafio.tecnico.repositories.PlanetaRepository;

@Service
public class PlanetaService {

	private static final String CONSULTA_NAO_RETORNOU_RESULTADO = "A consulta não retornou resultado.";
	
	@Autowired
	private PlanetaRepository repository;
	
	public PlanetaDomain obterPor(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ApiNotFoundException(CONSULTA_NAO_RETORNOU_RESULTADO));
	}
	
	public PlanetaDomain obterPor(String nome) {
		return repository.findByName(nome)
				.orElseThrow(() -> new ApiNotFoundException(CONSULTA_NAO_RETORNOU_RESULTADO));
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
