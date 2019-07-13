package com.desafio.tecnico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.tecnico.domains.PlanetaDomain;
import com.desafio.tecnico.integracao.SwapiService;
import com.desafio.tecnico.services.PlanetaService;

@RestController
@RequestMapping("/planeta")
public class PlanetaResource {

	@Autowired
	private PlanetaService planetaService;
	
	@Autowired
	private SwapiService swapiService;
	
	@GetMapping("/obter-por-id/{id}")
	public ResponseEntity<PlanetaDomain> obterPor(@PathVariable Integer id) {
		
		PlanetaDomain planeta = planetaService.obterPor(id);
		swapiService.obterAparicoesEmFilmePor(planeta);
		
		return ResponseEntity.ok(planeta);
	}
	
	@GetMapping("/obter-por-nome/{nome}")
	public ResponseEntity<PlanetaDomain> obterPor(@PathVariable String nome) {
		
		PlanetaDomain planeta = planetaService.obterPor(nome);
		swapiService.obterAparicoesEmFilmePor(planeta);
		
		return ResponseEntity.ok(planeta);
	}
	
	@GetMapping("/obter-todos")
	public ResponseEntity<List<PlanetaDomain>> obterTodos() {
		
		List<PlanetaDomain> planetas = planetaService.obterTodos();
		swapiService.obterAparicoesEmFilmePor(planetas);
		
		return ResponseEntity.ok(planetas);
	}
	
	@PostMapping("/inserir-por")
	public ResponseEntity<PlanetaDomain> inserirPor(@RequestBody PlanetaDomain planeta) {
		
		PlanetaDomain retornoPlaneta = planetaService.inserirPor(planeta);
		swapiService.obterAparicoesEmFilmePor(planeta);
		
		return ResponseEntity.ok(retornoPlaneta);
	}
	
	@DeleteMapping("/remover-por-id/{id}")
	public void removerPor(@PathVariable Integer id) {
		planetaService.removerPor(id);
	}
	
	
}
