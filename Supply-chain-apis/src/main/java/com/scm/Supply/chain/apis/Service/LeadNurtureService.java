package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.LeadNurture;
import com.scm.Supply.chain.apis.Repo.LeadNurtureRepository;

@Service
public class LeadNurtureService {

    private final LeadNurtureRepository leadNurtureRepository;

    @Autowired
    public LeadNurtureService(LeadNurtureRepository leadNurtureRepository) {
        this.leadNurtureRepository = leadNurtureRepository;
    }

    public List<LeadNurture> findLeadNurtureByLeadId(Long leadId) {
        return leadNurtureRepository.findLeadNurtureByLeadId(leadId);
    }

    public List<LeadNurture> findLeadNurtureByCampaignId(Long campaignId) {
        return leadNurtureRepository.findLeadNurtureByCampaignId(campaignId);
    }
    
    public LeadNurture findLeadNurtureById(Long id){
    	return leadNurtureRepository.findLeadNurtureById(id);
    }

    public List<LeadNurture> getAllLeadNurture() {
        return leadNurtureRepository.findAll();
    }

    public LeadNurture createLeadNurture(LeadNurture leadNurture) {
        return leadNurtureRepository.save(leadNurture);
    }

    public LeadNurture updateLeadNurture(LeadNurture leadNurture) {
        return leadNurtureRepository.save(leadNurture);
    }

    public void deleteLeadNurture(Long id) {
        leadNurtureRepository.deleteById(id);
    }
}