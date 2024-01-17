// task.reducer.ts

import { createReducer, on } from '@ngrx/store';
import { EntityState, EntityAdapter, createEntityAdapter } from '@ngrx/entity';
import { Task } from '../models/task.model';
import * as TaskActions from './task.actions';

export interface TaskState extends EntityState<Task> {
  // Additional state properties if needed
  loading: boolean;
  error: any;
}

export const adapter: EntityAdapter<Task> = createEntityAdapter<Task>();

const initialTaskState: TaskState = adapter.getInitialState({
  // Initial state properties if needed
  loading: false,
  error: null
});

const reducer = createReducer(
  initialTaskState,
  on(TaskActions.loadTasks, (state) => ({
    ...state,
    loading: true,
    error: null,
  })),
  on(TaskActions.tasksLoaded, (state, { tasks }) => ({
    ...adapter.setAll(tasks, state),
    loading: false,
    error: null,
  })),
  on(TaskActions.tasksLoadError, (state, { error }) => ({
    ...state,
    loading: false,
    error,
  })),
  on(TaskActions.editTask, (state, {task}) => ({
    ...adapter.updateOne({id:task.id!, changes:task}, state),
    loading: false,
    error:null
  })),
  on(TaskActions.deleteTask, (state,{taskId}) => ({
    ...adapter.removeOne(taskId,state),
    loading: false,
    error: null
  })),
  on(TaskActions.addTask, (state,{task}) => ({
    ...adapter.addOne(task, state),
    loading: false,
    error: null
  }))

);

export function taskReducer(state: TaskState | undefined, action: any) {
  return reducer(state, action);
}