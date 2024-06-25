package com.scm.Supply.chain.apis.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Appointment;
import com.scm.Supply.chain.apis.Service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
    private final AppointmentService appointmentService;
    
    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    
    @PostMapping
    public Appointment bookAppointment(@RequestParam Long doctorId,
                                       @RequestParam Long patientId,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        return appointmentService.bookAppointment(doctorId, patientId, startTime, endTime);
    }
    
    @DeleteMapping("/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
    }
    
    @GetMapping("/doctors/{id}")
    public List<Appointment> getAppointmentsForDoctor(@PathVariable Long id) {
        return appointmentService.getAppointmentsForDoctor(id);
    }
    
    @GetMapping("/patients/{id}")
    public List<Appointment> getAppointmentsForPatient(@PathVariable Long id) {
        return appointmentService.getAppointmentsForPatient(id);
    }
    
    @GetMapping
    public List<Appointment> getAppointmentsInRange(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return appointmentService.getAppointmentsInRange(start, end);
    }
    
    @PostMapping("/{id}/remind")
    public void sendAppointmentReminder(@PathVariable Long id) {
        appointmentService.sendAppointmentReminder(id);
    }
    
    @Scheduled(cron = "0 0 8 * * ?") // run at 8 AM every day
    public void sendDailyReminders() {
        appointmentService.sendRemindersForUpcomingAppointments();
    }
}
