import { Actions, createEffect, ofType } from '@ngrx/effects';
import { switchMap, map, catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import * as TaskActions from './task.actions';
import { Injectable } from '@angular/core';
import { TaskService } from '../service/task.service';

@Injectable()
export class TaskEffects {
  constructor(private actions$: Actions, private taskService: TaskService) {}

  loadTasks$ = createEffect(() :any=>
    this.actions$.pipe(
      ofType(TaskActions.loadTasks), // Filter for the 'loadTasks' action
      switchMap(() =>
        this.taskService.getTasks().pipe(
          map((tasks) => TaskActions.tasksLoaded({ tasks })), // Dispatch 'tasksLoaded' action
          catchError((error) => of(TaskActions.tasksLoadError({ error }))) // Handle errors
        )
      )
    )
  );

  // Other effects...
  editTask$ = createEffect(() =>
    this.actions$.pipe(
      ofType(TaskActions.editTask),
      switchMap(({ task }) =>
        this.taskService.editTask(task).pipe(
          map((editedTask) => TaskActions.taskEdited({ task: editedTask }))
        )
      )
    )
  );

  deletTask$ = createEffect(() =>
    this.actions$.pipe(
      ofType(TaskActions.deleteTask),
      switchMap(({ taskId }) =>
        this.taskService.deleteTask(taskId).pipe(
          map(() => TaskActions.taskDeleted())
        )
      )
    )
 );

 addTask$ = createEffect(() =>
 this.actions$.pipe(
   ofType(TaskActions.addTask),
   switchMap(({ task }) =>
     this.taskService.editTask(task).pipe(
       map((editedTask) => TaskActions.taskAdded({ task: editedTask }))
     )
   )
 )
);

}
