package com.scm.Supply.chain.apis.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.scm.Supply.chain.apis.Entity.Project;
import com.scm.Supply.chain.apis.Entity.Task;
import com.scm.Supply.chain.apis.Repo.ProjectRepository;

@Service
public class ProjectService {
	
    private final ProjectRepository projectRepository;
    
    private final TaskService taskService;
    
    private final RestTemplate restTemplate;
    
    @Value("${trello.api.key}")
    private final String trelloApiKey;
    
    @Value("${trello.api.token}")
    private final String trelloToken;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, TaskService taskService, RestTemplate restTemplate, String trelloApiKey, String trelloToken) {
        this.projectRepository = projectRepository;
        this.taskService = taskService;
        this.restTemplate = restTemplate;
        this.trelloApiKey = trelloApiKey;
        this.trelloToken = trelloToken;
    }

    public Project createProject(Project project) {
        Project savedProject = projectRepository.save(project);
        createTrelloBoard(savedProject);
        return savedProject;
    }

    private void createTrelloBoard(Project project) {
        String url = "https://api.trello.com/1/boards";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("key", trelloApiKey);
        params.add("token", trelloToken);
        params.add("name", project.getName());

        ResponseEntity<Map> response = restTemplate.postForEntity(url, params, Map.class);
        project.setTrelloBoardId(response.getBody().get("id").toString());
        projectRepository.save(project);
    }

    public Project getProjectById(Long id) throws Exception {
        return projectRepository.findById(id)
                .orElseThrow(() -> new Exception("Project not found with id: " + id));
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project updateProject(Long id, Project updatedProject) {
        Project project = getProjectById(id);
        project.setName(updatedProject.getName());
        project.setStartDate(updatedProject.getStartDate());
        project.setEndDate(updatedProject.getEndDate());
        project.setStatus(updatedProject.getStatus());
        updateTrelloBoard(project);
        return projectRepository.save(project);
    }

    private void updateTrelloBoard(Project project) {
        String url = "https://api.trello.com/1/boards/" + project.getTrelloBoardId();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("key", trelloApiKey);
        params.add("token", trelloToken);
        params.add("name", project.getName());

        restTemplate.put(url, params);
    }

    public void deleteProject(Long id) {
        Project project = getProjectById(id);
        deleteTrelloBoard(project);
        projectRepository.delete(project);
    }

    private void deleteTrelloBoard(Project project) {
        String url = "https://api.trello.com/1/boards/" + project.getTrelloBoardId();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("key", trelloApiKey);
        params.add("token", trelloToken);

        restTemplate.delete(url, params);
    }

    public Task addTaskToProject(Long projectId, Task task) {
        Project project = getProjectById(projectId);
        task.setProject(project);
        Task savedTask = taskService.createTask(task);
        createTrelloCard(project, savedTask);
        return savedTask;
    }

    private void createTrelloCard(Project project, Task task) {
        String url = "https://api.trello.com/1/boards/" + project.getTrelloBoardId() + "/cards";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("key", trelloApiKey);
        params.add("token", trelloToken);
        params.add("name", task.getName());
        params.add("desc", task.getDescription());
        params.add("due", task.getDueDate().toString());

        ResponseEntity<Map> response = restTemplate.postForEntity(url, params, Map.class);
        task.setTrelloCardId(response.getBody().get("id").toString());
        taskService.updateTask(task.getId(), task);
    }
}
