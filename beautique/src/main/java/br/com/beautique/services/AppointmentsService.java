package br.com.beautique.services;

import br.com.beautique.dtos.AppointmentDTO;

public interface AppointmentsService {
    
    AppointmentDTO create(AppointmentDTO aaAppointmentDTO);
    AppointmentDTO update(AppointmentDTO appointmentDTO);
    void  deleteById(Long Id);
    AppointmentDTO setCustomerToAppointment(AppointmentDTO appointmentDTO);
}
