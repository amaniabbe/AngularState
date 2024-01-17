
export interface Task {
    id?: string;
    name: string;
    description?: string; // Optional description property
    dueDate?: Date; // Optional due date property
    completed: boolean;
  }
  