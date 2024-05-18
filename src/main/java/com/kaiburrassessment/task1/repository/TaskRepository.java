package com.kaiburrassessment.task1.repository;

import com.kaiburrassessment.task1.model.Task;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByNameContaining(String name);
    List<Task> findByAssigneeOrderByStartTime(String assignee, Pageable pageable);
}
