package com.desafio.tecnico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafio.tecnico.domains.PlanetaDomain;
import com.desafio.tecnico.services.PlanetaService;

@SpringBootApplication
public class DesafioTecnicoApplication implements CommandLineRunner {

	@Autowired
	private PlanetaService planetaService;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioTecnicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		inserirExemplo();
	}

	/**
	 * Inserção de um exemplo caso a base inicie vazia
	 */
	private void inserirExemplo() {
		
		List<PlanetaDomain> planetas = planetaService.obterTodos();
		
		if (planetas.isEmpty()) {
			PlanetaDomain planeta = new PlanetaDomain();
			planeta.setId(1);
			planeta.setNome("aaa");
			planeta.setTerreno("bbb");
			planeta.setClima("ddd");
			
			planetaService.inserirPor(planeta);
		}
	}

}
