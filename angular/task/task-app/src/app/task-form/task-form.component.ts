import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'; // Import necessary form modules
import { Task } from '../models/task.model';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { addTask } from '../state/task.actions';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent {
  taskForm: FormGroup; // Define a form group

  constructor(private formBuilder: FormBuilder, private store:Store, private router:Router) {
    this.taskForm = this.formBuilder.group({
      taskName: ['', Validators.required], // Define form controls with validation
      taskDescription: ['', Validators.required] // Define form controls with validation
    });
  }

  saveTask() {
    if (this.taskForm.valid) {
      const taskName = this.taskForm.value.taskName;
      const taskDescription = this.taskForm.value.taskDescription
      let newTask: Task = {
        name: taskName,
        description: taskDescription,
        completed: false,
      }
     
      this.store.dispatch(addTask({task:newTask}));

      this.router.navigate(['dashboard']);

      // Handle task saving logic here, e.g., call the task service to add or edit the task.
    } else {
      // Handle form validation errors
    }
  }
}
