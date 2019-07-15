package com.desafio.tecnico.integracao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.tecnico.domains.PlanetaDomain;

@RunWith(SpringRunner.class)
public class SwapiServiceTest {

	@TestConfiguration
    static class SwapiServiceTestContextConfiguration {
  
        @Bean
        public SwapiService swapiService() {
            return new SwapiService();
        }
    }
	
	@Autowired
    private SwapiService swapiService;
	
	@Test
	public void deveObterPlanetaComAparicoesEmFilme() {
		PlanetaDomain planeta = new PlanetaDomain();
		planeta.setId(1);
		swapiService.obterAparicoesEmFilmePor(planeta);
		assertTrue(planeta.getAparicoesEmFilme() > 0);		
	}
	
	@Test
	public void deveObterPlanetaSemAparicoesEmFilme() {
		PlanetaDomain planeta = new PlanetaDomain();
		planeta.setId(193);
		swapiService.obterAparicoesEmFilmePor(planeta);
		assertTrue(planeta.getAparicoesEmFilme() == 0);		
	}
	
}
