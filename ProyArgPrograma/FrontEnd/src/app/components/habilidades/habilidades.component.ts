import { Component, OnInit } from '@angular/core';
import { Habilidades } from 'src/app/model/habilidades';
import { HabilidadesService } from 'src/app/service/habilidades.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-habilidades',
  templateUrl: './habilidades.component.html',
  styleUrls: ['./habilidades.component.css']
})
export class HabilidadesComponent implements OnInit {
  habilidad:Habilidades[]=[];
  
  constructor(private sHabilidades:HabilidadesService,private tokenServices:TokenService) { }
  isLogged=false;

  ngOnInit(): void {
    this.cargarHabilidades();
    if(this.tokenServices.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;
    }
  }

  cargarHabilidades():void{
    this.sHabilidades.lista().subscribe(data=>{this.habilidad=data;})
    }


  delete(id?:number){
    if (id !=undefined){
      this.sHabilidades.delete(id).subscribe(
        data=> {
          this.cargarHabilidades();
        }, err => {
          alert("No se pudo borrar la Habilidad");
        }
      )
    }
    }

}
