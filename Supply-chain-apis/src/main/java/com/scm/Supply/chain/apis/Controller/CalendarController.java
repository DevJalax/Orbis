package com.scm.Supply.chain.apis.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.CalendarEvent;
import com.scm.Supply.chain.apis.Service.CalendarService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
	
    private final CalendarService calendarService;
    
    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }
    
    @GetMapping("/doctors/{id}")
    public List<CalendarEvent> getCalendarEventsForDoctor(@PathVariable Long id) {
        return calendarService.getCalendarEventsForDoctor(id);
    }
    
    @GetMapping("/patients/{id}")
    public List<CalendarEvent> getCalendarEventsForPatient(@PathVariable Long id) {
        return calendarService.getCalendarEventsForPatient(id);
    }
    
    @GetMapping("/doctors/{id}/range")
    public List<CalendarEvent> getCalendarEventsInRangeForDoctor(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
                                                                @PathVariable Long id) {
        return calendarService.getCalendarEventsInRangeForDoctor(start, end, id);
    }
    
    @GetMapping("/patients/{id}/range")
    public List<CalendarEvent> getCalendarEventsInRangeForPatient(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
                                                                  @PathVariable Long id) {
        return calendarService.getCalendarEventsInRangeForPatient(start, end, id);
    }
}
