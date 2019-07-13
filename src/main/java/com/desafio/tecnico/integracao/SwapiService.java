package com.desafio.tecnico.integracao;

import static org.springframework.http.HttpMethod.GET;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.desafio.tecnico.domains.PlanetaDomain;
import com.desafio.tecnico.http.builder.HttpHeadersBuilder;
import com.desafio.tecnico.integracao.dto.SwapiDTO;

@Service
public class SwapiService {

	private static final Logger LOGGER = LogManager.getLogger(SwapiService.class);
	private static final String URL = "https://swapi.co/api/planets/";
	
	public void obterAparicoesEmFilmePor(PlanetaDomain planeta) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeadersBuilder().build();
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        
        int aparicoesEmFilme = 0;

        try {
        	SwapiDTO swapiDTO = restTemplate.exchange(URL + planeta.getId(), GET, entity, SwapiDTO.class).getBody();
        	aparicoesEmFilme = swapiDTO.getFilms().length;
		} catch (HttpClientErrorException e) {
			
			if(e.getStatusCode().compareTo(HttpStatus.NOT_FOUND) == 0) {
				LOGGER.info("| O planeta não foi encontrado: " + e.getLocalizedMessage());
			} else LOGGER.error("| Erro: " + e.getLocalizedMessage());
		}
        
        planeta.setAparicoesEmFilme(aparicoesEmFilme);
	}
	
	public void obterAparicoesEmFilmePor(List<PlanetaDomain> planetas) {
		if (!planetas.isEmpty()) {
			planetas.stream().forEach(planeta -> {
				obterAparicoesEmFilmePor(planeta);
			});
		}
	}
	
}
