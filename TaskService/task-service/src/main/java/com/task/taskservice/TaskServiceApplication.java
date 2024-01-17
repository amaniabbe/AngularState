package com.task.taskservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.task.taskservice.model.Task;
import com.task.taskservice.service.TaskService;

@SpringBootApplication
@EnableAsync
public class TaskServiceApplication implements CommandLineRunner {

	@Autowired
	private TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		taskService.addAsync(new Task(null, "Task name 1", "Task Description 1", false, null));
		taskService.addAsync(new Task( null,"Task name 2", "Task Description 2", false, null));
		taskService.addAsync(new Task( null,"Task name 3", "Task Description 3", false, null));
		taskService.addAsync(new Task( null,"Task name 4", "Task Description 4", false, null));
		taskService.addAsync(new Task(null,"Task name 5", "Task Description 5", false, null));
		taskService.addAsync(new Task(null,"Task name 6", "Task Description 6", false, null));

	}

}
