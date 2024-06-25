package com.scm.Supply.chain.apis.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.DTO.AppointmentStatus;
import com.scm.Supply.chain.apis.Entity.Appointment;
import com.scm.Supply.chain.apis.Entity.Doctor;
import com.scm.Supply.chain.apis.Entity.Patient;
import com.scm.Supply.chain.apis.Repo.AppointmentRepository;
import com.scm.Supply.chain.apis.Repo.DoctorRepository;
import com.scm.Supply.chain.apis.Repo.PatientRepository;

@Service
public class AppointmentService {
	
    private final AppointmentRepository appointmentRepository;
    
    private final DoctorRepository doctorRepository;
    
    private final PatientRepository patientRepository;
    
    public AppointmentService(AppointmentRepository appointmentRepository, 
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }
    
    public Appointment bookAppointment(Long doctorId, Long patientId, LocalDateTime startTime, LocalDateTime endTime) {
        
    	Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        
    	Patient patient = patientRepository.findById(patientId).orElseThrow();
        
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStartTime(startTime);
        appointment.setEndTime(endTime);
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        
        return appointmentRepository.save(appointment);
    }
    
    public void cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        appointment.setStatus(AppointmentStatus.CANCELLED);
        appointmentRepository.save(appointment);
    }
    
    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }
    
    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
    
    public List<Appointment> getAppointmentsInRange(LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByStartTimeBetween(start, end);
    }
    
    public void sendAppointmentReminder(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        if (!appointment.isReminderSent()) {
            // send reminder email/SMS to patient and doctor
            appointment.setIsReminderSent(true);
            appointment.setReminderSentAt(LocalDateTime.now());
            appointmentRepository.save(appointment);
        }
    }
    
    public void sendRemindersForUpcomingAppointments() {
        List<Appointment> upcomingAppointments = appointmentRepository.findByDoctorIdAndIsReminderSentFalse(getCurrentDoctorId());
        upcomingAppointments.addAll(appointmentRepository.findByPatientIdAndIsReminderSentFalse(getCurrentPatientId()));
        
        for (Appointment appointment : upcomingAppointments) {
            sendAppointmentReminder(appointment.getId());
        }
    }
}
