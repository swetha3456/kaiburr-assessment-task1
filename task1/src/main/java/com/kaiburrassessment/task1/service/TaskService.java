package com.kaiburrassessment.task1.service;

import com.kaiburrassessment.task1.model.Task;
import com.kaiburrassessment.task1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByName(String name) {
        return taskRepository.findByNameContaining(name);
    }

    public List<Task> getTasksByAssignee(String assignee) {
        return taskRepository.findByAssigneeOrderByStartTime(assignee, PageRequest.of(0, 10));
    }
}