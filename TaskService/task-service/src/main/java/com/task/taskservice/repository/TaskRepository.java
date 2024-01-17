package com.task.taskservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.task.taskservice.model.Task;

public interface TaskRepository extends MongoRepository<Task,String> {
    
}
