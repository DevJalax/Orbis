package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Lead;
import com.scm.Supply.chain.apis.Service.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    private final LeadService leadService;

    @Autowired
    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @GetMapping
    public ResponseEntity<List<Lead>> getAllLeads() {
        List<Lead> leads = leadService.getAllLeads();
        return new ResponseEntity<>(leads, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        Lead lead = leadService.findLeadById(id);
        return new ResponseEntity<>(lead, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
        Lead newLead = leadService.createLead(lead);
        return new ResponseEntity<>(newLead, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(@PathVariable Long id, @RequestBody Lead lead) {
        Lead updatedLead = leadService.updateLead(lead);
        return new ResponseEntity<>(updatedLead, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.deleteLead(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}