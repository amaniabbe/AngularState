import { createAction, props } from '@ngrx/store';
import { Task} from '../models/task.model'

export const addTask = createAction('[Task] Add Task', props<{ task: Task }>());
export const editTask = createAction('[Task] Edit Task', props<{ task: Task }>());
export const taskEdited = createAction('[Task] Task edited', props<{task:Task}>());
export const taskAdded = createAction('[Task] Task added', props<{task:Task}>());
export const deleteTask = createAction('[Task] Delete Task', props<{ taskId: string }>());
export const taskDeleted = createAction('[Task] Task Deleted');
export const loadTasks = createAction('[Task] Load Tasks');
export const tasksLoaded = createAction('[Task] Tasks Loaded', props<{ tasks: Task[] }>());
export const tasksLoadError = createAction('[Task] Tasks Load Error', props<{ error: any }>());

