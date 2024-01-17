import { inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

export const authGuard: CanActivateFn = (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  const isAuthenticated$ = authService.isAuthenticated();

  if(isAuthenticated$ === undefined)
    return router.navigate(['/login'])

  return isAuthenticated$.pipe( 
    tap(isAuthenticated => {
    
      if (isAuthenticated){
      console.log('INFO: authGuard Authenticated')
      return true; // Proceed with navigation
    } else {
      // Redirect to the login page or perform other actions
      // For example, return a UrlTree to navigate to the login page
      console.log('INFO: authGuard not Authenticated')
      return router.navigate(['/login'])
      }
  }));
}
