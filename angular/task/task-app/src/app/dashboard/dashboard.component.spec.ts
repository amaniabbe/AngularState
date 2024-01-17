import { ComponentFixture, fakeAsync, TestBed, tick } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TaskService } from '../service/task.service';
import { DashboardComponent } from './dashboard.component';
import { Task } from '../models/task.model';
import { of } from 'rxjs';

describe('DashboardComponent', () => {
  let component: DashboardComponent;
  let fixture: ComponentFixture<DashboardComponent>;
  let taskService: jasmine.SpyObj<TaskService>; // Mock TaskService
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DashboardComponent], // Add your component here
      imports: [HttpClientTestingModule], 
      providers: [TaskService], // Provide TaskService here
    });
    fixture = TestBed.createComponent(DashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    taskService = jasmine.createSpyObj('TaskService', ['getTasks']);
    httpTestingController = TestBed.inject(HttpTestingController);

  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('Should load tasks from task service', fakeAsync( () => {
    // Set up the mock data to be returned by the service
    const mockTasks: Task[] = [
      { id: 'id1', name: 'Task 1', description: 'Description 1', completed: false},
      { id: 'id2', name: 'Task 2', description: 'Description 2' , completed: false},
    ];



    taskService.getTasks.and.returnValue(of(mockTasks));

    // Trigger component initialization or method that uses the service
    component.ngOnInit(); // Or any method that retrieves tasks
    
    // Use tick to wait for async operations to complete
    tick();

    // Now, you can make assertions about how your component handles the mock data
    //expect(component.tasks$).toEqual(mockTasks);

  }));
});
