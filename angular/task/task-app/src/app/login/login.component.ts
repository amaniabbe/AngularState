import { Component } from '@angular/core';
import { authGuard } from '../auth/auth.guard';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string | undefined;
  password:string | undefined;

  constructor(private router:Router, private authService:AuthService){};
  
  login(){
    this.authService.authenticate(this.username! , this.password!);
    this.router.navigate(['/dashboard']);
  }
}
