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
import com.desafio.tecnico.services.PlanetaService;

@RestController
@RequestMapping("/planeta")
public class PlanetaResource {

	@Autowired
	private PlanetaService service;
	
	@GetMapping("/obter-por-id/{id}")
	public ResponseEntity<PlanetaDomain> obterPor(@PathVariable Integer id) {
		return ResponseEntity.ok(service.obterPor(id));
	}
	
	@GetMapping("/obter-por-nome/{nome}")
	public ResponseEntity<PlanetaDomain> obterPor(@PathVariable String nome) {
		return ResponseEntity.ok(service.obterPor(nome));
	}
	
	@GetMapping("/obter-todos")
	public ResponseEntity<List<PlanetaDomain>> obterTodos() {
		return ResponseEntity.ok(service.obterTodos());
	}
	
	@DeleteMapping("/remover-por-id/{id}")
	public void removerPor(@PathVariable Integer id) {
		service.removerPor(id);
	}
	
	@PostMapping("/inserir-por")
	public ResponseEntity<PlanetaDomain> inserirPor(@RequestBody PlanetaDomain planeta) {
		return ResponseEntity.ok(service.inserirPor(planeta));
	}
	
}
