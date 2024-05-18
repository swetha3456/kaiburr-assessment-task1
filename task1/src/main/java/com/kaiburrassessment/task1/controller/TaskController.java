package com.kaiburrassessment.task1.controller;

import java.util.List;
import com.kaiburrassessment.task1.model.Task;
import com.kaiburrassessment.task1.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

class taskInput {
    public String id;
    public String name;
    public String assignee;
    public String project;
}

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/")
    public Task createTask(@RequestBody taskInput input) {
        Task task = new Task(input.id, input.name, input.assignee, input.project);
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return "Task successfully deleted.";
    }
    
    @GetMapping("/name/{name}")
    public List<Task> getTasksByName(@PathVariable String name) {
        return taskService.getTasksByName(name);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTasksByAssignee(@PathVariable String assignee) {
        return taskService.getTasksByAssignee(assignee);
    }
}

