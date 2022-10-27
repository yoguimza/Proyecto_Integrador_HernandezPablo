import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyecto } from '../model/proyecto';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {
  //proyeURL="http://localhost:8080/proye/"
  proyeURL="https://backendpablo.herokuapp.com/proye/";

  constructor(private httpClient:HttpClient) { }
  public lista():Observable<Proyecto[]>{
    return this.httpClient.get<Proyecto[]>(this.proyeURL+'lista');
  }
  public detail(id:number):Observable<Proyecto>{
    return this.httpClient.get<Proyecto>(this.proyeURL+`detail/${id}`);
  }

  public save(proyecto:Proyecto):Observable<any>{
    return this.httpClient.post<any>(this.proyeURL+'create',proyecto);
  }

  public update(id:number,proyecto:Proyecto):Observable<any>{
    return this.httpClient.put<any>(this.proyeURL+`update/${id}`,proyecto);
  }

  public delete(id:number):Observable<any>{
    return this.httpClient.delete<any>(this.proyeURL+`delete/${id}`);
  }
}
