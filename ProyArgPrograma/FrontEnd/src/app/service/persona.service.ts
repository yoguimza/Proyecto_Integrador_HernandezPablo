import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  //URL='http://localhost:8080/personas/';
  URL='https://backendpablo.herokuapp.com/personas/';

  constructor(private httpClient: HttpClient) { }

  public lista():Observable<persona[]>{
    return this.httpClient.get<persona[]>(this.URL+'lista');
  }
  public detail(id:number):Observable<persona>{
    return this.httpClient.get<persona>(this.URL+`detail/${id}`);
  }

  /*public save(educacion:Educacion):Observable<any>{
    return this.httpClient.post<any>(this.eduURL+'create',educacion);
  }*/

  public update(id:number,Persona:persona):Observable<any>{
    return this.httpClient.put<any>(this.URL+`update/${id}`,Persona);
  }

  /*public delete(id:number):Observable<any>{
    return this.httpClient.delete<any>(this.eduURL+`delete/${id}`);
  }*/

  /*public getPersona():Observable<persona>{
    //return this.http.get<persona>(this.URL+'traer/perfil');
  }*/



}
