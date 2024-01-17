package com.task.taskservice.repository;

import java.util.ArrayList;
import java.util.List;


import com.task.taskservice.model.Task;


public class TaskMemoRepository {
    
    private List<Task> tasks;

    public TaskMemoRepository() {
        
        tasks = new ArrayList<Task>();
    }

    public Task addTask(Task task){
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public Task updateTask(Task updatedTask, int id){
        Task taskToUpdate = tasks.stream().filter(x->x.getId() == updatedTask.getId()).findAny().orElse(null);
        taskToUpdate = updatedTask;
        return taskToUpdate;
    }

    public void deleteTask(String taskid){
        tasks.removeIf(t -> t.getId() == taskid);
    }    
}
