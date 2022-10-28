import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ImageService } from 'src/app/service/image.service';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';
import { TokenService } from 'src/app/service/token.service';

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
              public imageServiceLogoE: ImageService,
              private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.imageServiceLogoE.clearUrl();

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
