package com.task.taskservice.controllers;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.task.taskservice.model.Task;
import com.task.taskservice.service.TaskService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

@WebMvcTest(TaskConroller.class)
public class TaskControllerTest {
    
    @MockBean
    private TaskService taskService;

    @MockBean
    private TaskConroller taskController;

    private MockMvc mockMvc;


    @BeforeMethod
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void testGetTaskById() throws Exception{
        // Task task = new Task("taskId", "task name", "task desc", false, null);

        // when(taskService.getTaskByIdAsync("taskId")).thenReturn(task);

        // mockMvc.perform(get("api/tasks/taskId")
        // .contentType(MediaType.APPLICATION_JSON))
        // .andExpect(status().isOk())
        // .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        // .andExpect(jsonPath("$.id").value("taskId"))
        // .andExpect(jsonPath("$.name").value("task name"));

    }
}
