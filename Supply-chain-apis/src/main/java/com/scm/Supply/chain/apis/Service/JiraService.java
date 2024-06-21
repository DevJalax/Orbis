package com.scm.Supply.chain.apis.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scm.Supply.chain.apis.Entity.Issue;

@Service
public class JiraService {

	JiraService jiraService = null;
	
	public List<Issue> searchIssues(String jql) throws UnsupportedEncodingException {
	    String url = "https://your-jira-instance.atlassian.net/rest/api/2/search";
	    String params = "jql=" + URLEncoder.encode(jql, "UTF-8");
		String response = jiraService.getForObject(url, params);
	    return parseResponse(response);
	}

	public String getForObject(String url, String params) {
	    OkHttpClient client = new OkHttpClient();
	    Request request = new Request.Builder()
	            .url(url + "?" + params)
	            .header("Authorization", "Bearer " + yourApiToken)
	            .header("Content-Type", "application/json")
	            .build();
	    Response response = client.newCall(request).execute();
	    return response.body().string();
	}

	public List<Issue> parseResponse(String response) {
	   
		 List<Issue> issues = new ArrayList<>();
		 ObjectMapper objectMapper = new ObjectMapper();
		 
		 try {
			 JsonNode rootNode = objectMapper.readTree(response);
			 JsonNode issuesNode = rootNode.get("issues");
			 
			 for (JsonNode issueNode : issuesNode) {
				 Issue issue = new Issue();
				 issue.setId(issueNode.get("id").asLong());
				  issue.setSummary(issueNode.get("fields").get("summary").asText());
		            issue.setDescription(issueNode.get("fields").get("description").asText());
		            issue.setStatus(issueNode.get("fields").get("status").get("name").asText());
		            issue.setPriority(issueNode.get("fields").get("priority").get("name").asText());
		            issue.setAssignee(issueNode.get("fields").get("assignee").get("name").asText());
		            issue.setCreatedDate(objectMapper.convertValue(issueNode.get("fields").get("created"), java.util.Date.class));
		            issue.setUpdatedDate(objectMapper.convertValue(issueNode.get("fields").get("updated"), java.util.Date.class));

		            issues.add(issue);
			 }
		 }catch (IOException e) {
		        e.printStackTrace();
		    }
	}
	
	return issues;
}
