import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { SProyectoService } from 'src/app/service/s-proyecto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-edit-proyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.css']
})
export class EditProyectoComponent implements OnInit {

  proy: Proyecto = null;

  constructor(private sProyecto: SProyectoService, 
              private activatedRoute: ActivatedRoute, 
              private router: Router,
              public imageServiceLogoP: ImageService,
              private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {

    const id = this.activatedRoute.snapshot.params['id'];

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.imageServiceLogoP.clearUrl();

    this.sProyecto.detail(id).subscribe(
      data => {
        this.proy = data;
      }, err => {
        alert("Error al modificar proyecto");
        this.router.navigate(['']);
      }
    )

  }

  onUpdate(): void {

    const id = this.activatedRoute.snapshot.params['id'];
    if(this.imageServiceLogoP.url != "") {
      this.proy.imagenP = this.imageServiceLogoP.url;
    }
    this.sProyecto.update(id, this.proy).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar proyecto");
        this.router.navigate(['']);
      }
    )

  }

  uploadImage($event:any) {

    const carpeta = "imagenProy"
    this.imageServiceLogoP.uploadImage($event, carpeta);

  }

    
}
