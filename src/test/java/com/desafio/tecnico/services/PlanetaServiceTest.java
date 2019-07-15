package com.desafio.tecnico.services;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.tecnico.domains.PlanetaDomain;
import com.desafio.tecnico.exception.ApiNotFoundException;
import com.desafio.tecnico.repositories.PlanetaRepository;

@RunWith(SpringRunner.class)
public class PlanetaServiceTest {

	private static final String OBJETO_NÃO_ENCONTRADO_NA_BASE_DE_DADOS = "Objeto não encontrado na base de dados.";
	private static final int ID_PLANETA_VALIDO = 1;
	private static final int ID_PLANETA_INVALIDO = 193;
	private static final String NOME_VALIDO = "Nome Válido";
	private static final String NOME_INVALIDO = "Nome Inválido";

	@TestConfiguration
	static class PlanetaServiceTestContextConfiguration {
		
		@Bean
		public PlanetaService planetaService() {
			return new PlanetaService();
		}
	}
	
	private Optional<PlanetaDomain> optPlaneta = Optional.of(new PlanetaDomain());
	
	@Autowired	
	private PlanetaService planetaService;
	
	@MockBean
	private PlanetaRepository planetaRepository;
	
	@Test
	public void deveObterPlanetaPorId() {
		Mockito.when(planetaRepository.findById(ID_PLANETA_VALIDO)).thenReturn(optPlaneta);
		PlanetaDomain planeta = planetaService.obterPor(ID_PLANETA_VALIDO);
		assertNotNull(planeta);
	}
	
	@Test(expected = ApiNotFoundException.class)
	public void deveObterVazioAoBuscarPorId() {
		Mockito.when(planetaRepository.findById(ID_PLANETA_INVALIDO))
			.thenThrow(new ApiNotFoundException(OBJETO_NÃO_ENCONTRADO_NA_BASE_DE_DADOS));
		planetaService.obterPor(ID_PLANETA_INVALIDO);
	}
	
	@Test
	public void deveObterPlanetaPorNome() {
		Mockito.when(planetaRepository.findByName(NOME_VALIDO)).thenReturn(optPlaneta);
		PlanetaDomain planeta = planetaService.obterPor(NOME_VALIDO);
		assertNotNull(planeta);
	}
	
	@Test(expected = ApiNotFoundException.class)
	public void deveObterVazioAoBuscarPorNome() {
		Mockito.when(planetaRepository.findByName(NOME_INVALIDO))
		.thenThrow(new ApiNotFoundException(OBJETO_NÃO_ENCONTRADO_NA_BASE_DE_DADOS));
		planetaService.obterPor(NOME_INVALIDO);
	}
	
}
