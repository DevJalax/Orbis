package com.scm.Supply.chain.apis.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.DTO.LoanStatus;
import com.scm.Supply.chain.apis.Entity.Customer;
import com.scm.Supply.chain.apis.Entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
    List<Loan> findByCustomer(Customer customer);
    
    List<Loan> findByStatus(LoanStatus status);

}
