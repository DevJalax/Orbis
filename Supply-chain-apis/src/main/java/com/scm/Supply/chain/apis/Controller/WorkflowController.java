package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.WorkflowInstance;
import com.scm.Supply.chain.apis.Service.WorkflowService;

@RestController
@RequestMapping("/workflows")
public class WorkflowController {
	
    private final WorkflowService workflowService;

    @Autowired
    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping
    public ResponseEntity<Void> startWorkflow(@RequestParam String processName) {
        workflowService.startWorkflow(processName);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{workflowInstanceId}/complete")
    public ResponseEntity<Void> completeWorkflow(@PathVariable Long workflowInstanceId) {
        workflowService.completeWorkflow(workflowInstanceId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<WorkflowInstance>> getWorkflowInstances(@RequestParam(required = false) String status) {
        List<WorkflowInstance> workflowInstances;
        if (status != null) {
            workflowInstances = workflowService.getWorkflowInstances(status);
        } else {
            workflowInstances = workflowService.getWorkflowInstancesByProcess(status);
        }
        return ResponseEntity.ok(workflowInstances);
    }
}
