import { Component, Input } from '@angular/core';
import { Store } from '@ngrx/store';
import { Task } from '../models/task.model';
import { TaskService } from '../service/task.service';
import { deleteTask, editTask } from '../state/task.actions';

@Component({
  selector: 'app-task-item',
  templateUrl: './task-item.component.html',
  styleUrls: ['./task-item.component.css']
})
export class TaskItemComponent {


  @Input() task!: Task;
  taskLocal!: Task;

  constructor(private store:Store){}

  ngOnInit(){
    this.taskLocal = {...this.task};
  }

  deleteTask(){
     if(this.taskLocal.id != null)
     {
        this.store.dispatch(deleteTask({taskId: this.taskLocal.id}));
        console.log(this.taskLocal);
     }
      
  }

  updateTask(){
      this.store.dispatch(editTask({task:this.taskLocal}));
  }
}
