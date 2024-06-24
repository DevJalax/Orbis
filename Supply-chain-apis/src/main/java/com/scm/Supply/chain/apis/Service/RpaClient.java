package com.scm.Supply.chain.apis.Service;

import org.springframework.stereotype.Service;

@Service
public class RpaClient {
	
    private final RpaService rpaService;

    public RpaClient(RpaService rpaService) {
        this.rpaService = rpaService;
    }

    public void performRpaTasks(WorkflowInstance workflowInstance) {
        // Perform RPA tasks based on the workflow instance
        rpaService.performTaskA(workflowInstance);
        rpaService.performTaskB(workflowInstance);
        rpaService.performTaskC(workflowInstance);
    }
}
