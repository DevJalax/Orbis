package com.scm.Supply.chain.apis.Entity;

import java.time.LocalDateTime;

import com.scm.Supply.chain.apis.DTO.AppointmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment_details")
public class Appointment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime startTime;
    
    private LocalDateTime endTime;
    
    private AppointmentStatus status;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    private boolean isReminderSent;
    
    private LocalDateTime reminderSentAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean isReminderSent() {
		return isReminderSent;
	}

	public void setReminderSent(boolean isReminderSent) {
		this.isReminderSent = isReminderSent;
	}

	public LocalDateTime getReminderSentAt() {
		return reminderSentAt;
	}

	public void setReminderSentAt(LocalDateTime reminderSentAt) {
		this.reminderSentAt = reminderSentAt;
	}
    
}
