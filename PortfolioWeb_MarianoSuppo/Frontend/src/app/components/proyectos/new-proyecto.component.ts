import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { SProyectoService } from 'src/app/service/s-proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {
  
  nombreP: string = '';
  descripcionP: string = '';
  imagenP: string = '';
  fechaP: string = '';
  linkP: string = '';

  constructor(private sProyecto: SProyectoService, 
              private router: Router,
              public imageServiceLogoP: ImageService) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    this.imagenP = this.imageServiceLogoP.url;
    const proy = new Proyecto(this.nombreP, this.descripcionP, this.imagenP, this.fechaP, this.linkP);
    this.sProyecto.save(proy).subscribe(
      data => {
        alert("Proyecto añadido");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
    this.imageServiceLogoP.clearUrl();

  }

  uploadImage($event:any) {

    const carpeta = "imagenProy"
    this.imageServiceLogoP.uploadImage($event, carpeta);

  }

  cancel(): void {

    this.imageServiceLogoP.clearUrl();
    this.router.navigate(['']);

  }

}
