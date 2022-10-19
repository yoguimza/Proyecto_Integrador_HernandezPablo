import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { persona } from 'src/app/model/persona.model';
import { ImageService } from 'src/app/service/image.service';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-edit-acercade',
  templateUrl: './edit-acercade.component.html',
  styleUrls: ['./edit-acercade.component.css']
})
export class EditAcercadeComponent implements OnInit {
persona:persona=null;
  constructor(private sPersona:PersonaService, private activatedRouter: ActivatedRoute,
    private router: Router, public imageService:ImageService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sPersona.detail(id).subscribe(
      data =>{
        this.persona=data;
      },err =>{
        alert("Error al modificar Persona");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate() {
    const id = this.activatedRouter.snapshot.params['id'];
    this.persona.img=this.imageService.url
    this.sPersona.update(id, this.persona).subscribe(
      data=> {
        this.router.navigate(['']);
      },err =>{
        alert("Error al modificar Persona");
        this.router.navigate(['']);
      }
    )
  }

  uploadImage($event:any) {
    const id=this.activatedRouter.snapshot.params['id'];
    const name="perfil_"+id;
    this.imageService.uploadImage($event,name)
  }

}
