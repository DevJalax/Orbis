package com.scm.Supply.chain.apis.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    @Query("SELECT c FROM Campaign c WHERE c.name = :name")
    Campaign findCampaignByName(@Param("name") String name);

    @Query("SELECT c FROM Campaign c WHERE c.description = :description")
    Campaign findCampaignByDescription(@Param("description") String description);
    
    @Query("SELECT c FROM Campaign c WHERE c.id = :id")
    Campaign findCampaignById(@Param("id") Long id);
}
