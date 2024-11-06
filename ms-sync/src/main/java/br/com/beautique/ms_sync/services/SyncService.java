package br.com.beautique.ms_sync.services;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentsDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProceduresDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;

public interface SyncService {

    void syncCustomer(CustomerDTO customerDTO);

    void syncAppointment(FullAppointmentsDTO fullAppointmentsDTO);

    void syncBeautyProcedure(BeautyProceduresDTO beautyProceduresDTO);
}
