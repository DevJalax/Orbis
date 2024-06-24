package com.scm.Supply.chain.apis.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long employeeId;
    
    private LocalDate date;
    
    private AttendanceStatus status;
    
    private LocalTime clockIn;
    
    private LocalTime clockOut;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AttendanceStatus getStatus() {
		return status;
	}

	public void setStatus(AttendanceStatus status) {
		this.status = status;
	}

	public LocalTime getClockIn() {
		return clockIn;
	}

	public void setClockIn(LocalTime clockIn) {
		this.clockIn = clockIn;
	}

	public LocalTime getClockOut() {
		return clockOut;
	}

	public void setClockOut(LocalTime clockOut) {
		this.clockOut = clockOut;
	}
   
    
    
}
