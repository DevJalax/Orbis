package com.scm.Supply.chain.apis.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	 Optional<Customer> findById(String id);
	
}
