package br.com.beautique.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beautique.dtos.AppointmentDTO;
import br.com.beautique.services.AppointmentsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentsService;

    @PostMapping
    ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentsService.create(appointmentDTO));
    }

    @PatchMapping
    ResponseEntity<AppointmentDTO> update(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentsService.update(appointmentDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id) {
        appointmentsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity<AppointmentDTO> setCustomerToAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentsService.setCustomerToAppointment(appointmentDTO));
    }

}
