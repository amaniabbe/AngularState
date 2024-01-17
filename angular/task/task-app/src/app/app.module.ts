import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TaskFormComponent } from './task-form/task-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MenuBarComponent } from './menu-bar/menu-bar.component';
import { TaskItemComponent } from './task-item/task-item.component';
import { StoreModule } from '@ngrx/store';
import { taskReducer } from './state/task.reducer';
import { TaskEffects } from './state/task.effects';
import { EffectsModule } from '@ngrx/effects';
import { AuthService } from './service/auth.service';
import { Router } from '@angular/router';
import { LocalStorageService } from './service/local-storage.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    TaskFormComponent,
    MenuBarComponent,
    TaskItemComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    StoreModule.forRoot({tasks: taskReducer}),
    EffectsModule.forRoot(TaskEffects)
  ],
  providers: [AuthService, Router, LocalStorageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
