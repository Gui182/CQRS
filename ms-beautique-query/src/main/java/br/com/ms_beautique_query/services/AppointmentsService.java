package br.com.ms_beautique_query.services;

import java.util.List;

import br.com.ms_beautique_query.dtos.appointments.FullAppointmentDTO;

public interface AppointmentsService {

    List<FullAppointmentDTO> listAllAppointments();

    List<FullAppointmentDTO> listAllAppointmentsByCustomer(Long customerId);

    List<FullAppointmentDTO> listAllAppointmentsByBeautyProcedure(Long beautyProcedureId);
}
