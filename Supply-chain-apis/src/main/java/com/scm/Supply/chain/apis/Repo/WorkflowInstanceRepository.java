package com.scm.Supply.chain.apis.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.WorkflowInstance;

@Repository
public interface WorkflowInstanceRepository extends JpaRepository<WorkflowInstance, Long> {
	
    List<WorkflowInstance> findByStatus(String status);
    
    List<WorkflowInstance> findByProcessName(String processName);

}
