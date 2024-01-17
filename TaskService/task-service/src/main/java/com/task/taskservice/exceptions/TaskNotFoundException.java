package com.task.taskservice.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message){
        super(message);
    }    
}
