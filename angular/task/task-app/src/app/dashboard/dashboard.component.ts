import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { loadTasks } from '../state/task.actions';
import { selectAllTasks, selectTaskError, selectTaskLoading } from '../state/task.selector';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  tasks$ = this.store.select(selectAllTasks);
  loading$ = this.store.select(selectTaskLoading);
  error$ = this.store.select(selectTaskError);


  constructor(private store:Store){}

  ngOnInit(){
    this.store.dispatch(loadTasks());
  }

}
