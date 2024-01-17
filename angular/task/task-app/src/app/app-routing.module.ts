import { NgModule } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { TaskFormComponent } from './task-form/task-form.component';
import { authGuard } from './auth/auth.guard';
import { AuthService } from './service/auth.service';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  // { path: 'dashboard', loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule)},
  // { path: 'task-form', loadChildren: () => import('./task-form/task-form.module').then(m => m.TaskFormModule) }
  { 
    path: 'dashboard',
     component: DashboardComponent, 
     canActivate: [authGuard]
  },
  { 
    path: 'task-form', 
    component: TaskFormComponent, 
    canActivate:[authGuard] 
  } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
