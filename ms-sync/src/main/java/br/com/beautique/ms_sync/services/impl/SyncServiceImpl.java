package br.com.beautique.ms_sync.services.impl;

import org.springframework.stereotype.Service;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentsDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProceduresDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;
import br.com.beautique.ms_sync.services.SyncService;

@Service
public class SyncServiceImpl implements SyncService {

    @Override
    public void syncCustomer(CustomerDTO customerDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'syncCustomer'");
    }

    @Override
    public void syncAppointment(FullAppointmentsDTO fullAppointmentsDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'syncAppointment'");
    }

    @Override
    public void syncBeautyProcedure(BeautyProceduresDTO beautyProceduresDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'syncBeautyProcedure'");
    }

}
