package br.com.beautique.ms_sync.listeners.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentsDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProceduresDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;
import br.com.beautique.ms_sync.listeners.ListenerConfig;
import br.com.beautique.ms_sync.services.SyncService;
import br.com.beautique.ms_sync.utils.SyncLogger;

@Configuration
public class RabbitMQListenerConfig implements ListenerConfig {

    private final ObjectMapper objectMapper;
    private final SyncService syncService;

    public RabbitMQListenerConfig(ObjectMapper objectMapper, SyncService syncService) {
        this.objectMapper = objectMapper;
        this.syncService = syncService;
    }

    @RabbitListener(queues = "CustomerQueue")
    @Override
    public void listenToCustomerQueue(String message) {
        try {
            CustomerDTO customer = objectMapper.readValue(message, CustomerDTO.class);
            syncService.syncCustomer(customer);
            SyncLogger.info("Message received from Queue customerQueue: " + customer.toString());
        } catch (Exception e) {
            SyncLogger.error("Error listen customer queue: " + e.getMessage());
        }
    }

    @RabbitListener(queues = "appointmentQueue")
    @Override
    public void listenToAppointmentQueue(String message) {
        try {
            FullAppointmentsDTO fullAppointments = objectMapper.readValue(message, FullAppointmentsDTO.class);
            syncService.syncAppointment(fullAppointments);
            SyncLogger.info("Message received from queue appointmentQueue:  " + fullAppointments.toString());
        } catch (Exception e) {
            SyncLogger.error("Error listen appointment queue: " + e.getMessage());
        }
    }

    @RabbitListener(queues = "beautyProcedureQueue")
    @Override
    public void listenToBeautyProceduresQueue(String message) {
        try {
            BeautyProceduresDTO beautyProcedures = objectMapper.readValue(message, BeautyProceduresDTO.class);
            syncService.syncBeautyProcedure(beautyProcedures);
            SyncLogger.info("Message received from queue beautyProcedureQueue: " + beautyProcedures.toString());
        } catch (Exception e) {
            SyncLogger.error("Error listen beauty procedure queue: " + e.getMessage());
        }
    }

}
