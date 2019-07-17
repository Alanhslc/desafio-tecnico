package com.desafio.tecnico.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.desafio.tecnico.domains.PlanetaDomain;

public interface PlanetaRepository extends MongoRepository<PlanetaDomain, Integer> {

	@Query("{'_id': ?0}")
	Optional<PlanetaDomain> findById(ObjectId id);
	
	@Query("{'nome': ?0}")
	Optional<PlanetaDomain> findByName(String name);
	
}
