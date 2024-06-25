package com.scm.Supply.chain.apis.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
    Optional<Patient> findByEmail(String email);

}
