package br.com.beautique.ms_sync.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProceduresDTO;

public interface BeautyProcedureRepository extends MongoRepository<BeautyProceduresDTO, Long> {

}
