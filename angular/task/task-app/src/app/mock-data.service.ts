import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable({
    providedIn: 'root',
  })
export class MockDataService implements InMemoryDbService {
    private MaxId = 6;
  createDb() {
    const tasks = [
      { id: 1, name: 'Task 1', description: 'Task Description 1', completed: false },
      { id: 2, name: 'Task 2', description: 'Tesk Description 2', completed: true },
      { id: 3, name: 'Task 3', description: 'Task Description 3', completed: true },
      { id: 4, name: 'Task 4', description: 'Task Description 4', completed: true },
      { id: 5, name: 'Task 5', description: 'Task Description 5', completed: true },
      { id: 6, name: 'Task 6', description: 'Task Description 6', completed: true },
      // Add more mock tasks as needed
    ];

    return { tasks };
  }

  genId(): number {
    // Find the maximum ID in the existing collection
    this.MaxId++;
    // Generate a new ID by adding 1 to the maximum ID
    return this.MaxId;
  }
}
