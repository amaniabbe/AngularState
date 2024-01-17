import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor() { }

  setItem(key:any, value:any){
    localStorage.setItem(key,value);
  }

  getItem<T>(key:any){
    const item = localStorage.getItem(key);
    return item ? JSON.parse(item) : null;
  }

  removeItem(key:any){
    localStorage.removeItem(key);
  }
}
