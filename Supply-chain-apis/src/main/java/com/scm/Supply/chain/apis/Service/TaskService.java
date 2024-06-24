package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Task;
import com.scm.Supply.chain.apis.Repo.TaskRepository;

@Service
public class TaskService {
	
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) throws Exception {
        return taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task not found with id: " + id));
    }

    public List<Task> getAllTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTaskById(id);
        task.setName(updatedTask.getName());
        task.setDescription(updatedTask.getDescription());
        task.setDueDate(updatedTask.getDueDate());
        task.setStatus(updatedTask.getStatus());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }
}
