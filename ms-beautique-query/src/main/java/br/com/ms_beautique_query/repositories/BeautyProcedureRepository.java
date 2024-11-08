package br.com.ms_beautique_query.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ms_beautique_query.dtos.beautyprocedures.BeautyProcedureDTO;

public interface BeautyProcedureRepository extends MongoRepository<BeautyProcedureDTO, Long> {

}
