package com.scm.Supply.chain.apis.Repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
    List<Appointment> findByDoctorId(Long doctorId);
    
    List<Appointment> findByPatientId(Long patientId);
    
    List<Appointment> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
    
    List<Appointment> findByDoctorIdAndIsReminderSentFalse(Long doctorId);
    
    List<Appointment> findByPatientIdAndIsReminderSentFalse(Long patientId);
}

