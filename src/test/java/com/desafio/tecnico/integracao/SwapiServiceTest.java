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
import com.desafio.tecnico.integracao.dto.SwapiDTO;

@RunWith(SpringRunner.class)
public class SwapiServiceTest {

	private static final int ID_VALIDO = 1;
	private static final int ID_INVALIDO = 193;

	private static final String URL = "https://swapi.co/api/planets/";
	
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
		this.planetaComAparicoesEmFilme.setFilms(new String[] {"film1"});
		
		this.planetaSemAparicoesEmFilme = new SwapiDTO();
		this.planetaSemAparicoesEmFilme.setFilms(new String[] {});
	} 
	
	private SwapiDTO planetaComAparicoesEmFilme;
	private SwapiDTO planetaSemAparicoesEmFilme;
	
	@Autowired
    private SwapiService swapiService;
	
	@MockBean
	private RestTemplate restTemplate;
	
	@Test
	public void deveObterPlanetaComAparicoesEmFilme() {
		
		Mockito.when(restTemplate.getForObject(URL + ID_VALIDO, SwapiDTO.class))
			.thenReturn(this.planetaComAparicoesEmFilme);
		
		PlanetaDomain planeta = new PlanetaDomain();
		planeta.setId(ID_VALIDO);
		
		swapiService.obterAparicoesEmFilmePor(planeta);
		assertTrue(planeta.getAparicoesEmFilme() > 0);		
	}
	
	@Test
	public void deveObterPlanetaSemAparicoesEmFilme() {
		
		Mockito.when(restTemplate.getForObject(URL + ID_INVALIDO, SwapiDTO.class))
			.thenReturn(this.planetaSemAparicoesEmFilme);
		
		PlanetaDomain planeta = new PlanetaDomain();
		planeta.setId(ID_INVALIDO);
		
		swapiService.obterAparicoesEmFilmePor(planeta);
		assertTrue(planeta.getAparicoesEmFilme() == 0);		
	}
	
}
