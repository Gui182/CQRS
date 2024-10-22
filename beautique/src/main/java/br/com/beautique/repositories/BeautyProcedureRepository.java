package br.com.beautique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.beautique.entities.BeautyProceduresEntity;

public interface BeautyProcedureRepository extends JpaRepository<BeautyProceduresEntity, Long> {

}
