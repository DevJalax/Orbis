package com.scm.Supply.chain.apis.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.MedicalHistory;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
	
    List<MedicalHistory> findByPatientId(Long patientId);

}
