package com.task.taskservice.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.task.taskservice.model.Task;
import com.task.taskservice.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Async
    public CompletableFuture<Task> addAsync(Task task){
        return  CompletableFuture.completedFuture(taskRepository.insert(task));
    }

    @Async
    public CompletableFuture<List<Task>> getTasksAsync(){
        return CompletableFuture.completedFuture(taskRepository.findAll());
    }

    @Async
    public CompletableFuture<Task> updateAsync(Task task, String id){
        return CompletableFuture.completedFuture(taskRepository.save(task));
    }

    @Async
    public void delete(String id){
        taskRepository.deleteById(id);
    }

    @Async
    public CompletableFuture<Task> getTaskByIdAsync(String id) {
        return CompletableFuture.completedFuture((taskRepository.findById(id).orElse(null)));
    }
    
}
