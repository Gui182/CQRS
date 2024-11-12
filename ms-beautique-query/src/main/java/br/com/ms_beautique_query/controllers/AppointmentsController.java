package br.com.ms_beautique_query.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms_beautique_query.dtos.appointments.FullAppointmentDTO;
import br.com.ms_beautique_query.services.AppointmentsService;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {

    private final AppointmentsService appointmentsService;

    public AppointmentsController(AppointmentsService appointmentsService) {
        this.appointmentsService = appointmentsService;
    }

    @GetMapping()
    ResponseEntity<List<FullAppointmentDTO>> listAllAppointments() {
        return ResponseEntity.ok(appointmentsService.listAllAppointments());
    }

    @GetMapping("/customer/{customerId}")
    ResponseEntity<List<FullAppointmentDTO>> listAllAppointmentsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(appointmentsService.listAllAppointmentsByCustomer(customerId));
    }

    @GetMapping("/beauty-procedure/{beautyProcedureId}")
    ResponseEntity<List<FullAppointmentDTO>> listAllAppointmentsByBeautyProcedureId(
            @PathVariable Long beautyProcedureId) {
        return ResponseEntity.ok(appointmentsService.listAllAppointmentsByCustomer(beautyProcedureId));
    }
}
