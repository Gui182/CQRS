package br.com.beautique.ms_sync.services.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentsDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProceduresDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;
import br.com.beautique.ms_sync.services.AppointmentService;
import br.com.beautique.ms_sync.services.BeautyProcedureService;
import br.com.beautique.ms_sync.services.CustomerService;
import br.com.beautique.ms_sync.services.SyncService;
import br.com.beautique.ms_sync.utils.SyncLogger;

@Service
public class SyncServiceImpl implements SyncService {

    private final AppointmentService appointmentService;
    private final CustomerService customerService;
    private final BeautyProcedureService beautyProcedureService;

    public SyncServiceImpl(AppointmentService appointmentService, CustomerService customerService,
            BeautyProcedureService beautyProcedureService) {
        this.appointmentService = appointmentService;
        this.customerService = customerService;
        this.beautyProcedureService = beautyProcedureService;
    }

    @Override
    public void syncCustomer(CustomerDTO customerDTO) {
        try {
            SyncLogger.info("Saving customer:  " + customerDTO.getId());
            customerService.saveCustomer(customerDTO);
            SyncLogger.info("Updating appointment customer:  " + customerDTO.getId());
            appointmentService.updateAppointmentCustomer(customerDTO);
        } catch (Exception e) {
            SyncLogger.error("Error saving customer: " + e.getMessage());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void syncAppointment(FullAppointmentsDTO fullAppointmentsDTO) {
        try {
            SyncLogger.info("Saving appointment:  " + fullAppointmentsDTO.getId());
            appointmentService.saveAppointment(fullAppointmentsDTO);
        } catch (Exception e) {
            SyncLogger.error("Error saving appointment: " + e.getMessage());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void syncBeautyProcedure(BeautyProceduresDTO beautyProceduresDTO) {
        try {
            SyncLogger.info("Saving beauty procedure:  " + beautyProceduresDTO.getId());
            beautyProcedureService.saveBeautyProcedure(beautyProceduresDTO);
            SyncLogger.info("Updating appointment beauty procedure:  " + beautyProceduresDTO.getId());
            appointmentService.updateAppointmentBeautyProcedure(beautyProceduresDTO);
        } catch (Exception e) {
            SyncLogger.error("Error saving beauty procedure: " + e.getMessage());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }

}
