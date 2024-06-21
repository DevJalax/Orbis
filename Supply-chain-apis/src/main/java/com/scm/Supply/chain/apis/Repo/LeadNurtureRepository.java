package com.scm.Supply.chain.apis.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.LeadNurture;

@Repository
public interface LeadNurtureRepository extends JpaRepository<LeadNurture, Long> {

    @Query("SELECT ln FROM LeadNurture ln WHERE ln.leadId = :leadId")
    List<LeadNurture> findLeadNurtureByLeadId(@Param("leadId") Long leadId);

    @Query("SELECT ln FROM LeadNurture ln WHERE ln.campaignId = :campaignId")
    List<LeadNurture> findLeadNurtureByCampaignId(@Param("campaignId") Long campaignId);
    
    @Query("SELECT ln FROM LeadNurture ln WHERE ln.id = :id")
    LeadNurture findLeadNurtureById(@Param("id") Long id);
}
