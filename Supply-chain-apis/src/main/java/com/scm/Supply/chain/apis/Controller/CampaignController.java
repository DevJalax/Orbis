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

import com.scm.Supply.chain.apis.Entity.Campaign;
import com.scm.Supply.chain.apis.Service.CampaignService;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable Long id) {
        Campaign campaign = campaignService.findCampaignById(id);
        return new ResponseEntity<>(campaign, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) {
        Campaign newCampaign = campaignService.createCampaign(campaign);
        return new ResponseEntity<>(newCampaign, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable Long id, @RequestBody Campaign campaign) {
        Campaign updatedCampaign = campaignService.updateCampaign(campaign);
        return new ResponseEntity<>(updatedCampaign, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        campaignService.deleteCampaign(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
