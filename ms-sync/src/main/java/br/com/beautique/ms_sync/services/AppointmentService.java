package br.com.beautique.ms_sync.services;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentsDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProceduresDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;

public interface AppointmentService {

    void saveAppointment(FullAppointmentsDTO fullAppointmentsDTO);

    void updateAppointmentCustomer(CustomerDTO customerDTO);

    void updateAppointmentBeautyProcedure(BeautyProceduresDTO beautyProceduresDTO);
}
