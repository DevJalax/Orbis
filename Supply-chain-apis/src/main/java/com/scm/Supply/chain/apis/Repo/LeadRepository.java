package com.scm.Supply.chain.apis.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scm.Supply.chain.apis.Entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    @Query("SELECT l FROM Lead l WHERE l.email = :email")
    Lead findLeadByEmail(@Param("email") String email);

    @Query("SELECT l FROM Lead l WHERE l.name = :name")
    Lead findLeadByName(@Param("name") String name);

    @Query("SELECT l FROM Lead l WHERE l.phone = :phone")
    Lead findLeadByPhone(@Param("phone") String phone);
    
    @Query("SELECT l FROM Lead l WHERE l.id = :id")
    Lead findLeadById(@Param("id") Long id );
}
