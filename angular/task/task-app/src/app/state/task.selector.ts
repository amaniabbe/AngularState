import { createFeatureSelector, createSelector } from '@ngrx/store';
import { adapter, TaskState } from './task.reducer';

export const selectTaskState = createFeatureSelector<TaskState>('tasks');

export const selectAllTasks = createSelector(selectTaskState, adapter.getSelectors().selectAll);
export const selectTaskLoading = createSelector(selectTaskState, (state) => state.loading);
export const selectTaskError = createSelector(selectTaskState, (state) => state.error);
