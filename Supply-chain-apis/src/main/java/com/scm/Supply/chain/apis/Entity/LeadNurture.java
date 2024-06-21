package com.scm.Supply.chain.apis.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lead_nurture")
public class LeadNurture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long leadId;

    @Column(nullable = false)
    private Long campaignId;

    @Column(nullable = false)
    private LocalDateTime nurtureDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLeadId() {
		return leadId;
	}

	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}

	public Long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public LocalDateTime getNurtureDate() {
		return nurtureDate;
	}

	public void setNurtureDate(LocalDateTime nurtureDate) {
		this.nurtureDate = nurtureDate;
	}

}
