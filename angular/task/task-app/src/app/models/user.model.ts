import { BehaviorSubject } from "rxjs";

export class User{
  userId: string | undefined;
  private isAuthenticatedSource = new BehaviorSubject<boolean>(false);
  isAuthenticated$ = this.isAuthenticatedSource.asObservable();
}