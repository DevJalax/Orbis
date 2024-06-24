package com.scm.Supply.chain.apis.Repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
	
    List<Report> findByCreatedAtAfter(LocalDateTime timestamp);
    
}
