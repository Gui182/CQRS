package br.com.beautique.ms_sync.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentsDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProceduresDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;
import br.com.beautique.ms_sync.repositories.AppointmentRepository;
import br.com.beautique.ms_sync.services.AppointmentService;
import br.com.beautique.ms_sync.utils.SyncLogger;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveAppointment(FullAppointmentsDTO fullAppointmentsDTO) {
        try {
            SyncLogger.info("Saving appointment:  " + fullAppointmentsDTO.getId());
            appointmentRepository.save(fullAppointmentsDTO);
        } catch (Exception e) {
            SyncLogger.error("Error saving appointment: " + fullAppointmentsDTO.getId());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void updateAppointmentCustomer(CustomerDTO customerDTO) {
        try {
            SyncLogger.info("Updating  appointment customer" + customerDTO.getId());
            Query query = new Query(Criteria.where("customer.id").is(customerDTO.getId()));
            Update update = new Update().set("customer", customerDTO);
            mongoTemplate.updateMulti(query, update, FullAppointmentsDTO.class);
        } catch (Exception e) {
            SyncLogger.error("Error updating appointment customer: " + e.getMessage());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void updateAppointmentBeautyProcedure(BeautyProceduresDTO beautyProceduresDTO) {
        try {
            SyncLogger.info("Updating beauty procedure" + beautyProceduresDTO.getId());
            Query query = new Query(Criteria.where("beautyProcedure.id").is(beautyProceduresDTO.getId()));
            Update update = new Update()
            .set("beautyProcedure.name", beautyProceduresDTO.getName())
            .set("beautyProcedure.description", beautyProceduresDTO.getDescription());
            mongoTemplate.updateMulti(query, update, FullAppointmentsDTO.class);
        } catch (Exception e) {
            SyncLogger.error("Error updating appointment customer: " + e.getMessage());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }

}
