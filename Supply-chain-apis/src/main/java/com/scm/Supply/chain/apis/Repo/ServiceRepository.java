package com.scm.Supply.chain.apis.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	
    Optional<Service> findByName(String name);

}
