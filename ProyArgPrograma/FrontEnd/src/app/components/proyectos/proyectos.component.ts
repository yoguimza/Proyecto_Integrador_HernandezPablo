import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {
  proy:Proyecto[]=[];

  constructor(private sProyecto:ProyectoService,private tokenServices:TokenService) { }
  isLogged=false;

  ngOnInit(): void {
    this.cargarProyecto();
    if(this.tokenServices.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;
    }
  }

  cargarProyecto():void{
    this.sProyecto.lista().subscribe(data=>{this.proy=data;})
    }


  delete(id?:number){
    if (id !=undefined){
      this.sProyecto.delete(id).subscribe(
        data=> {
          this.cargarProyecto();
        }, err => {
          alert("No se pudo borrar el Proyecto");
        }
      )
    }
    }

}
