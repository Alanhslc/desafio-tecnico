package com.desafio.tecnico.integracao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.desafio.tecnico.domains.PlanetaDomain;
import com.desafio.tecnico.integracao.dto.ResultDTO;
import com.desafio.tecnico.integracao.dto.SwapiDTO;

@RunWith(SpringRunner.class)
public class SwapiServiceTest {

	private static final String NOME_VALIDO = "Nome Válido";
	private static final String NOME_INVALIDO = "Nome Inválido";

	private static final String URL = "https://swapi.co/api/planets/?search=";
	
	@TestConfiguration
    static class SwapiServiceTestContextConfiguration {
  
        @Bean
        public SwapiService swapiService() {
            return new SwapiService();
        }
    }
	
	@Before
	public void setup() {
		this.planetaComAparicoesEmFilme = new SwapiDTO();
		this.resultsComFilmes = new ResultDTO[2];
		
		ResultDTO result1 = new ResultDTO();
		result1.setFilms(new String[] {"film1", "film2"});
		ResultDTO result2 = new ResultDTO();
		result2.setFilms(new String[] {"film3"});
		
		this.resultsComFilmes[0] = result1;
		this.resultsComFilmes[1] = result2;
		this.planetaComAparicoesEmFilme.setResults(resultsComFilmes);
		
		this.planetaSemAparicoesEmFilme = new SwapiDTO();
		this.resultSemFilmes = new ResultDTO[0];
		this.planetaSemAparicoesEmFilme.setResults(resultSemFilmes);
	} 
	
	private SwapiDTO planetaComAparicoesEmFilme;
	private SwapiDTO planetaSemAparicoesEmFilme;
	
	private ResultDTO[] resultsComFilmes;
	private ResultDTO[] resultSemFilmes;
	
	@Autowired
    private SwapiService swapiService;
	
	@MockBean
	private RestTemplate restTemplate;
	
	@Test
	public void deveObterPlanetaComAparicoesEmFilme() {
		
		Mockito.when(restTemplate.getForObject(URL + NOME_VALIDO, SwapiDTO.class))
			.thenReturn(this.planetaComAparicoesEmFilme);
		
		PlanetaDomain planeta = new PlanetaDomain();
		planeta.setNome(NOME_VALIDO);
		
		swapiService.obterAparicoesEmFilmePor(planeta);
		assertTrue(planeta.getAparicoesEmFilme() > 0);		
	}
	
	@Test
	public void deveObterPlanetaSemAparicoesEmFilme() {
		
		Mockito.when(restTemplate.getForObject(URL + NOME_INVALIDO, SwapiDTO.class))
			.thenReturn(this.planetaSemAparicoesEmFilme);
		
		PlanetaDomain planeta = new PlanetaDomain();
		planeta.setNome(NOME_INVALIDO);
		
		swapiService.obterAparicoesEmFilmePor(planeta);
		assertTrue(planeta.getAparicoesEmFilme() == 0);		
	}
	
}
