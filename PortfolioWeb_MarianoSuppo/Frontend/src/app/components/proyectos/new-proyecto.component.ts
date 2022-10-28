import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { SProyectoService } from 'src/app/service/s-proyecto.service';
import { TokenService } from 'src/app/service/token.service';

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
              public imageServiceLogoP: ImageService,
              private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.imageServiceLogoP.clearUrl();

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

  }

  uploadImage($event:any) {

    const carpeta = "imagenProy"
    this.imageServiceLogoP.uploadImage($event, carpeta);

  }

 
}
