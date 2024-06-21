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

import com.scm.Supply.chain.apis.Entity.LeadNurture;
import com.scm.Supply.chain.apis.Service.LeadNurtureService;

@RestController
@RequestMapping("/api/lead-nurture")
public class LeadNurtureController {

    private final LeadNurtureService leadNurtureService;

    @Autowired
    public LeadNurtureController(LeadNurtureService leadNurtureService) {
        this.leadNurtureService = leadNurtureService;
    }

    @GetMapping
    public ResponseEntity<List<LeadNurture>> getAllLeadNurture() {
        List<LeadNurture> leadNurture = leadNurtureService.getAllLeadNurture();
        return new ResponseEntity<>(leadNurture, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadNurture> getLeadNurtureById(@PathVariable Long id) {
        LeadNurture leadNurture = leadNurtureService.findLeadNurtureById(id);
        return new ResponseEntity<>(leadNurture, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LeadNurture> createLeadNurture(@RequestBody LeadNurture leadNurture) {
        LeadNurture newLeadNurture = leadNurtureService.createLeadNurture(leadNurture);
        return new ResponseEntity<>(newLeadNurture, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeadNurture> updateLeadNurture(@PathVariable Long id, @RequestBody LeadNurture leadNurture) {
        LeadNurture updatedLeadNurture = leadNurtureService.updateLeadNurture(leadNurture);
        return new ResponseEntity<>(updatedLeadNurture, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeadNurture(@PathVariable Long id) {
        leadNurtureService.deleteLeadNurture(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
