package com.scm.Supply.chain.apis.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Appointment;
import com.scm.Supply.chain.apis.Entity.CalendarEvent;
import com.scm.Supply.chain.apis.Repo.CalendarEventRepository;

@Service
public class CalendarService {
	
    private final CalendarEventRepository calendarEventRepository;
    
    @Autowired
    public CalendarService(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }
    
    public CalendarEvent createCalendarEvent(Appointment appointment) {
        CalendarEvent calendarEvent = new CalendarEvent();
        calendarEvent.setStart(appointment.getStartTime());
        calendarEvent.setEnd(appointment.getEndTime());
        calendarEvent.setTitle(appointment.getDoctor().getName() + " - " + appointment.getPatient().getFirstName());
        calendarEvent.setDescription(appointment.getDoctor().getSpeciality());
        calendarEvent.setDoctor(appointment.getDoctor());
        calendarEvent.setPatient(appointment.getPatient());
        calendarEvent.setAppointment(appointment);
        
        return calendarEventRepository.save(calendarEvent);
    }
    
    public List<CalendarEvent> getCalendarEventsForDoctor(Long doctorId) {
        return calendarEventRepository.findByDoctorId(doctorId);
    }
    
    public List<CalendarEvent> getCalendarEventsForPatient(Long patientId) {
        return calendarEventRepository.findByPatientId(patientId);
    }
    
    public List<CalendarEvent> getCalendarEventsInRangeForDoctor(LocalDateTime start, LocalDateTime end, Long doctorId) {
        return calendarEventRepository.findByStartBetweenAndDoctorId(start, end, doctorId);
    }
    
    public List<CalendarEvent> getCalendarEventsInRangeForPatient(LocalDateTime start, LocalDateTime end, Long patientId) {
        return calendarEventRepository.findByStartBetweenAndPatientId(start, end, patientId);
    }
}
