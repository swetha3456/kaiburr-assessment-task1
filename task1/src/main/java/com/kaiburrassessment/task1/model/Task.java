package com.kaiburrassessment.task1.model;

import java.time.LocalDateTime;
import java.util.Random;
import org.springframework.data.annotation.Id;

public class Task {
    @Id
    public String id;
    public String name;
    public String assignee;
    public String project;
    public LocalDateTime startTime;
    public String swethaMuraliProperty;

    public String generateRandomString() {
        String characters = "SwethaMurali";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }

        return randomString.toString();
    }
    
    public Task() {}
    
    public Task(String id, String name, String assignee, String project) {
        this.id = id;
        this.name = name;
        this.assignee = assignee;
        this.project = project;
        this.startTime = LocalDateTime.now();
        this.swethaMuraliProperty = generateRandomString();
    }
}
