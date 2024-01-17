import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task.model';
//import { MockDataService } from '../mock-data.service';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private tasksUrl = 'http://localhost:8080/api/tasks'; // This URL corresponds to the 'tasks' data defined in MockDataService

  constructor(private http: HttpClient) {}

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.tasksUrl);
  }

  addTask(newTask:Task) :Observable<Task> {
    return this.http.post<Task>(this.tasksUrl, newTask);
  }

  editTask(updatedTask:Task):Observable<Task> {
    const url = `${this.tasksUrl}/${updatedTask.id}`; // Construct the URL for the specific task
    // Perform an HTTP PUT request to update the task
    return this.http.put<Task>(url, updatedTask);
  }

  deleteTask(taskId: string):Observable<void> {
    const url = `${this.tasksUrl}/${taskId}`;
    return this.http.delete<void>(url);
  }
}
