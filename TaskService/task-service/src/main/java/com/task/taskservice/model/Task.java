package com.task.taskservice.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {

  @Id
  private String id;
  private String name;
  private String description;
  private boolean completed;
  private LocalDate dueDate;


}
