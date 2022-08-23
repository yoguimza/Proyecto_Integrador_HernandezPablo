import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Habilidades } from 'src/app/model/habilidades';
import { HabilidadesService } from 'src/app/service/habilidades.service';

@Component({
  selector: 'app-new-habilidades',
  templateUrl: './new-habilidades.component.html',
  styleUrls: ['./new-habilidades.component.css']
})
export class NewHabilidadesComponent implements OnInit {
  nombreH:string='';
  valorH:string='';

  constructor(private sHabilidades:HabilidadesService, private router:Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const habi=new Habilidades(this.nombreH,this.valorH);
    this.sHabilidades.save(habi).subscribe(
      data=>{
        alert("Habilidad añadida");
        this.router.navigate(['']);
      }, err=>{
        alert("Fallo");
        this.router.navigate(['']);
      }
    )
  }

}
