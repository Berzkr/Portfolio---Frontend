import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ImageService } from 'src/app/service/image.service';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';

@Component({
  selector: 'app-edit-experiencia',
  templateUrl: './edit-experiencia.component.html',
  styleUrls: ['./edit-experiencia.component.css']
})
export class EditExperienciaComponent implements OnInit {

  expLab: Experiencia = null;

  constructor(private sExperiencia: SExperienciaService,
              private activatedRoute: ActivatedRoute, 
              private router: Router,
              public imageServiceLogoE: ImageService) { }

  ngOnInit(): void {

    const id = this.activatedRoute.snapshot.params['id'];
    this.sExperiencia.detail(id).subscribe(
      data => {
        this.expLab = data;
      }, err => {
        alert("Error al modificar experiencia");
        this.router.navigate(['']);
      }
    )

  }

  onUpdate(): void {

    const id = this.activatedRoute.snapshot.params['id'];
    this.expLab.logoE = this.imageServiceLogoE.url;
    this.sExperiencia.update(id, this.expLab).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar experiencia");
        this.router.navigate(['']);
      }
    )

  }

  uploadImage($event:any) {

    const carpeta = "logoExpe"
    this.imageServiceLogoE.uploadImage($event, carpeta);

  }

}
