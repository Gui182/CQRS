package br.com.ms_beautique_query.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ms_beautique_query.dtos.appointments.FullAppointmentDTO;
import br.com.ms_beautique_query.repositories.AppointmentRepository;
import br.com.ms_beautique_query.services.AppointmentsService;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentsServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<FullAppointmentDTO> listAllAppointments() {
        try {
            return appointmentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error listening all appointments");
        }
    }

    @Override
    public List<FullAppointmentDTO> listAllAppointmentsByCustomer(Long customerId) {
        try {
            return appointmentRepository.listAppointmentsByCustomer(customerId);
        } catch (Exception e) {
            throw new RuntimeException("Error listening all appointments by customer");
        }
    }

    @Override
    public List<FullAppointmentDTO> listAllAppointmentsByBeautyProcedure(Long beautyProcedureId) {
        try {
            return appointmentRepository.listAppointmentsByBeautyProcedureId(beautyProcedureId);
        } catch (Exception e) {
            throw new RuntimeException("Error listening all appointments by beauty procedure");
        }
    }
    
}
