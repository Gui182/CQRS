package br.com.beautique.ms_sync.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentsDTO;

public interface AppointmentRepository extends MongoRepository<FullAppointmentsDTO, Long> {

}
