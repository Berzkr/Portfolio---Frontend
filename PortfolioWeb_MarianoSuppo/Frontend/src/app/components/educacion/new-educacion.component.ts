import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { ImageService } from 'src/app/service/image.service';
import { SEducacionService } from 'src/app/service/s-educacion.service';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css']
})
export class NewEducacionComponent implements OnInit {

  nombreEdu: string = '';
  descripcionEdu: string = '';
  fechaInicioEdu: string = '';
  fechaFinEdu: string = '';
  logoEdu: string = '';

  constructor(private sEducacion: SEducacionService, 
              private router: Router, 
              public imageServiceLogo: ImageService) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    this.logoEdu = this.imageServiceLogo.url;
    const edu = new Educacion(this.nombreEdu, this.descripcionEdu, this.fechaInicioEdu, this.fechaFinEdu, this.logoEdu);
    this.sEducacion.save(edu).subscribe(
      data => {
        alert("Educación añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
    this.imageServiceLogo.clearUrl();
  }

  uploadImage($event:any) {

    const carpeta = "logoEdu"
    this.imageServiceLogo.uploadImage($event, carpeta);

  }

  cancel(): void {

    this.imageServiceLogo.clearUrl();
    this.router.navigate(['']);

  }

}
