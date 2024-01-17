package com.task.taskservice.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.task.taskservice.exceptions.TaskNotFoundException;
import com.task.taskservice.model.Task;
import com.task.taskservice.service.TaskService;

@RestController
@RequestMapping(("/api/tasks"))
@CrossOrigin(origins = "http://localhost:4200")
public class TaskConroller {
    
    @Autowired
    private TaskService taskService;
    
    
    @GetMapping
    public CompletableFuture<List<Task>> getTasks(){
        return taskService.getTasksAsync();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Task> getTaskById(@PathVariable String id){
        return taskService.getTaskByIdAsync(id).thenApply(task -> {
            if(task == null){
                throw new TaskNotFoundException("the request task is not found");
            }

            return task;
        }).exceptionally(Throwable -> {
            // Handle exceptions, e.g., database errors
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
        });
                

    }


    @PutMapping("/{id}")
    public CompletableFuture<Task> updateTask(@RequestBody Task task, @PathVariable String id){
        return taskService.updateAsync(task, id);
    }

    @PostMapping
    public CompletableFuture<Task> addTask(@RequestBody Task task){
        return taskService.addAsync(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){
        taskService.delete(id);
    }
}
