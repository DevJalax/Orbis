package com.scm.Supply.chain.apis.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.WorkflowInstance;
import com.scm.Supply.chain.apis.Repo.WorkflowInstanceRepository;

@Service
public class WorkflowService {
	
    private final WorkflowInstanceRepository workflowInstanceRepository;
    
    private final TemporalClient temporalClient;
    
    private final RpaClient rpaClient;

    @Autowired
    public WorkflowService(
        WorkflowInstanceRepository workflowInstanceRepository,
        TemporalClient temporalClient,
        RpaClient rpaClient
    ) {
        this.workflowInstanceRepository = workflowInstanceRepository;
        this.temporalClient = temporalClient;
        this.rpaClient = rpaClient;
    }

    public void startWorkflow(String processName) {
        WorkflowInstance workflowInstance = new WorkflowInstance();
        workflowInstance.setProcessName(processName);
        workflowInstance.setStatus("STARTED");
        workflowInstance.setStartTime(LocalDateTime.now());
        workflowInstanceRepository.save(workflowInstance);

        // Start the Temporal workflow
        temporalClient.startWorkflow(processName, workflowInstance.getId());
    }

    public void completeWorkflow(Long workflowInstanceId) {
        WorkflowInstance workflowInstance = workflowInstanceRepository.findById(workflowInstanceId)
            .orElseThrow(() -> new IllegalArgumentException("Workflow instance not found"));

        // Complete the Temporal workflow
        temporalClient.completeWorkflow(workflowInstanceId);

        // Perform RPA tasks
        rpaClient.performRpaTasks(workflowInstance);

        workflowInstance.setStatus("COMPLETED");
        workflowInstance.setEndTime(LocalDateTime.now());
        workflowInstanceRepository.save(workflowInstance);
    }

    public List<WorkflowInstance> getWorkflowInstances(String status) {
        return workflowInstanceRepository.findByStatus(status);
    }

    public List<WorkflowInstance> getWorkflowInstancesByProcess(String processName) {
        return workflowInstanceRepository.findByProcessName(processName);
    }
}
