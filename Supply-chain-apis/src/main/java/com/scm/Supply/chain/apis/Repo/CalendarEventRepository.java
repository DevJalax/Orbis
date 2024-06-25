package com.scm.Supply.chain.apis.Repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.CalendarEvent;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
	
    List<CalendarEvent> findByDoctorId(Long doctorId);
    
    List<CalendarEvent> findByPatientId(Long patientId);
    
    List<CalendarEvent> findByStartBetweenAndDoctorId(LocalDateTime start, LocalDateTime end, Long doctorId);
    
    List<CalendarEvent> findByStartBetweenAndPatientId(LocalDateTime start, LocalDateTime end, Long patientId);
}
