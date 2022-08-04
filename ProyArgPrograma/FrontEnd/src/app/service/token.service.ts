import { Injectable } from '@angular/core';



const TOKEN_KEY = 'authToken';
const USERNAME_KEY = 'authUsername';
const AUTHORITIES_KEY = 'authAuthorities';




@Injectable({
  providedIn: 'root'
})
export class TokenService {
  roles: Array<String>=[];

  constructor() { }

  public setToken(token: string): void{
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token)
  }

  public getToken(): string{
    return sessionStorage.getItem(TOKEN_KEY)!;
  }

  public setUserName(userName: string): void{
    window.sessionStorage.removeItem(USERNAME_KEY);
    window.sessionStorage.setItem(USERNAME_KEY, userName);
  }

  public getUserName(): string{
    return sessionStorage.getItem(USERNAME_KEY)!;
  }

  public setAuthorities(authorities: string[]): void{
    window.sessionStorage.removeItem(AUTHORITIES_KEY);
    window.sessionStorage.setItem(AUTHORITIES_KEY, JSON.stringify(authorities));
  }

  public getAuthorities(): String[]{
    this.roles=[];
    if (sessionStorage.getItem(AUTHORITIES_KEY)){
      JSON.parse(sessionStorage.getItem(AUTHORITIES_KEY)!).forEach((authority:any) => {
        this.roles.push(authority.authority);
      });
    }
    return this.roles;
  }

  public logout():void{
    window.sessionStorage.clear();
  }
}
