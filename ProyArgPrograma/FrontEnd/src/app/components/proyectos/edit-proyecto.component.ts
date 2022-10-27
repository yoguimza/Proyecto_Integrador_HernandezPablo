import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-edit-proyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.css']
})
export class EditProyectoComponent implements OnInit {
  proy: Proyecto=null;
  constructor(private sProyecto:ProyectoService, private activatedRouter: ActivatedRoute,
    private router: Router, public imageService:ImageService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProyecto.detail(id).subscribe(
      data =>{
        this.proy=data;
      },err =>{
        alert("Error al modificar Proyecto");
        this.router.navigate(['']);
      }
    )
  }
  
  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.proy.fotoPr=this.imageService.url
    this.sProyecto.update(id, this.proy).subscribe(
      data=> {
        this.router.navigate(['']);
      },err =>{
        alert("Error al modificar Proyecto");
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
