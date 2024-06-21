package com.scm.Supply.chain.apis.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Issue;
import com.scm.Supply.chain.apis.Service.JiraService;

@RestController
@RequestMapping("/issue/customer-ticket")
public class JiraController {

	private final JiraService jiraService;

	@Autowired
    public JiraController(JiraService jiraService) {
        this.jiraService = jiraService;
    }

	  @GetMapping("/issues/{username}")
	    public ResponseEntity<List<Issue>> getIssuesForUser(@PathVariable String username) throws UnsupportedEncodingException {
	        String jql = "assignee = " + username;
	        return ResponseEntity.ok(jiraService.searchIssues(jql));
	    }
	
}
