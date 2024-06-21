package com.scm.Supply.chain.apis.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("SELECT e FROM Email e WHERE e.subject = :subject")
    Email findEmailBySubject(@Param("subject") String subject);

    @Query("SELECT e FROM Email e WHERE e.body = :body")
    Email findEmailByBody(@Param("body") String body);
    
    @Query("SELECT e FROM Email e WHERE e.id = :id")
    Email findEmailById(@Param("id") Long id);
}
