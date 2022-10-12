import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-edit-acercade',
  templateUrl: './edit-acercade.component.html',
  styleUrls: ['./edit-acercade.component.css']
})
export class EditAcercadeComponent implements OnInit {
persona:persona=null;
  constructor(private sPersona:PersonaService, private activatedRouter: ActivatedRoute,
    private router: Router) { }

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
  }

}
