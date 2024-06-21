package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Campaign;
import com.scm.Supply.chain.apis.Repo.CampaignRepository;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Campaign findCampaignByName(String name) {
        return campaignRepository.findCampaignByName(name);
    }

    public Campaign findCampaignByDescription(String description) {
        return campaignRepository.findCampaignByDescription(description);
    }
    
    public Campaign findCampaignById(Long id) {
    	return campaignRepository.findCampaignById(id);
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign createCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }
}
