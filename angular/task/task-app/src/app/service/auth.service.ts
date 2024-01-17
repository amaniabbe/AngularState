import { Inject, Injectable } from '@angular/core';
import { Router, UrlTree } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../models/user.model';
import { LocalStorageService } from './local-storage.service';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private  user:User | undefined;
  private isAuthenticatedSource = new BehaviorSubject<boolean>(false);

  private isAuthenticated$ = this.isAuthenticatedSource.asObservable();

  constructor(private router: Router, private localStorageService: LocalStorageService){ 
    this.user = new User(); 
  }

  authenticate(userid:string, password:string){

    this.localStorageService.removeItem('admin');

    if(userid == 'admin' && password == 'admin')
    {
      this.user!.userId = userid;
      this.localStorageService.setItem(userid, true);
      this.isAuthenticatedSource.next(true);
    }
      
    else 
      this.isAuthenticatedSource.next(false);
  } 
  

  isAuthenticated() : Observable<boolean> | undefined{

    const isAuthenticated = this.localStorageService.getItem<{key:string}>('admin');
    isAuthenticated == true ? this.isAuthenticatedSource.next(true): this.isAuthenticatedSource.next(false);
    return this.isAuthenticated$;
  }

  logOut(){
    this.localStorageService.removeItem('admin');
    this.isAuthenticatedSource.next(false);
    this.router.navigate(['/login']);
  }

}
