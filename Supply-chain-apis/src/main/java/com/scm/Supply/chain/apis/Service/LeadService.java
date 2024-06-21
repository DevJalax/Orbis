package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Lead;
import com.scm.Supply.chain.apis.Repo.LeadRepository;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    @Autowired
    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead findLeadByEmail(String email) {
        return leadRepository.findLeadByEmail(email);
    }

    public Lead findLeadByName(String name) {
        return leadRepository.findLeadByName(name);
    }

    public Lead findLeadByPhone(String phone) {
        return leadRepository.findLeadByPhone(phone);
    }
    
    public Lead findLeadById(Long id) {
    	return leadRepository.findLeadById(id);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Lead createLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public Lead updateLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
}
