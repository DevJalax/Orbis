package com.scm.Supply.chain.apis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemporalClient {
	
    private final Client temporalClient;

    @Autowired
    public TemporalClient(Client temporalClient) {
        this.temporalClient = temporalClient;
    }

    public void startWorkflow(String processName, Long workflowInstanceId) {
        WorkflowOptions options = WorkflowOptions.newBuilder()
            .setTaskQueue("default-task-queue")
            .setWorkflowId(workflowInstanceId.toString())
            .build();

        WorkflowStub workflow = temporalClient.newWorkflowStub(ProcessWorkflow.class, options);
        workflow.start(processName);
    }

    public void completeWorkflow(Long workflowInstanceId) {
        WorkflowStub workflow = temporalClient.newWorkflowStub(ProcessWorkflow.class, workflowInstanceId.toString());
        workflow.complete();
    }
}
