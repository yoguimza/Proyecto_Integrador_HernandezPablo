import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Habilidades } from '../model/habilidades';

@Injectable({
  providedIn: 'root'
})
export class HabilidadesService {
  habiliURL="http://localhost:8080/habili/"
  //habiliURL="https://backendpablo.herokuapp.com/habili/";


  constructor(private httpClient:HttpClient) { }
  public lista():Observable<Habilidades[]>{
    return this.httpClient.get<Habilidades[]>(this.habiliURL+'lista');
  }
  public detail(id:number):Observable<Habilidades>{
    return this.httpClient.get<Habilidades>(this.habiliURL+`detail/${id}`);
  }

  public save(habilidades:Habilidades):Observable<any>{
    return this.httpClient.post<any>(this.habiliURL+'create',habilidades);
  }

  public update(id:number,habilidades:Habilidades):Observable<any>{
    return this.httpClient.put<any>(this.habiliURL+`update/${id}`,habilidades);
  }

  public delete(id:number):Observable<any>{
    return this.httpClient.delete<any>(this.habiliURL+`delete/${id}`);
  }
}
