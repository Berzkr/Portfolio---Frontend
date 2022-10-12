import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ImageService } from 'src/app/service/image.service';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit {

  nombreE: string = '';
  descripcionE: string = '';
  fechaInicioE: string = '';
  fechaFinE: string = '';
  logoE: string = '';

  constructor(private sExperiencia: SExperienciaService, 
              private router: Router,
              public imageServiceLogoE: ImageService) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    this.logoE = this.imageServiceLogoE.url;
    const expe = new Experiencia(this.nombreE, this.descripcionE, this.fechaInicioE, this.fechaFinE, this.logoE);
    this.sExperiencia.save(expe).subscribe(
      data => {
        alert("Experiencia añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )

  }

  uploadImage($event:any) {

    const carpeta = "logoExpe"
    this.imageServiceLogoE.uploadImage($event, carpeta);

  }

}
