import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  edu:Educacion[]=[];

  constructor(private sEducacion:EducacionService,private tokenServices:TokenService) { }
  isLogged=false;

  ngOnInit(): void {
    this.cargarEducacion();
    if(this.tokenServices.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;
    }
  }

  cargarEducacion():void{
    this.sEducacion.lista().subscribe(data=>{this.edu=data;})
    }


  delete(id?:number){
    if (id !=undefined){
      this.sEducacion.delete(id).subscribe(
        data=> {
          this.cargarEducacion();
        }, err => {
          alert("No se pudo borrar la Educacion");
        }
      )
    }
    }




}
