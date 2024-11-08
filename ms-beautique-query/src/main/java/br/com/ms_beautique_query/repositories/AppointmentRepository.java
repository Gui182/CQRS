package br.com.ms_beautique_query.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ms_beautique_query.dtos.appointments.FullAppointmentDTO;

public interface AppointmentRepository extends MongoRepository<FullAppointmentDTO, Long> {

}
