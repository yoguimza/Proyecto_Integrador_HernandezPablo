import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewproyectoComponent implements OnInit {
  nombrePr:string='';
  descripcionPr:string='';
  fotoPr:string='';

  constructor(private sProyecto:ProyectoService, private activatedRouter: ActivatedRoute,private router:Router,public imageService:ImageService) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const proy=new Proyecto(this.nombrePr,this.descripcionPr,this.fotoPr);
    this.fotoPr=this.imageService.url
    this.sProyecto.save(proy).subscribe(
      data=>{
        alert("Proyecto añadido");
        this.router.navigate(['']);
      }, err=>{
        alert("Fallo");
        this.router.navigate(['']);
      }
    )
  }

  uploadImage($event:any) {
    const id=this.activatedRouter.snapshot.params['id'];
    const name="proyecto_"+id;
    this.imageService.uploadImage($event,name)
  }
}
