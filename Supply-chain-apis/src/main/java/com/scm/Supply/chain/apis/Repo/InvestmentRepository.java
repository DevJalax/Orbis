package com.scm.Supply.chain.apis.Repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
	
    List<Investment> findByName(String name);
    
    List<Investment> findByInvestmentDateBetween(LocalDate startDate, LocalDate endDate);
    
}
