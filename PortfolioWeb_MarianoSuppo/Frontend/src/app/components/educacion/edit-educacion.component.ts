import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { ImageService } from 'src/app/service/image.service';
import { SEducacionService } from 'src/app/service/s-educacion.service';

@Component({
  selector: 'app-edit-educacion',
  templateUrl: './edit-educacion.component.html',
  styleUrls: ['./edit-educacion.component.css']
})
export class EditEducacionComponent implements OnInit {

  educ: Educacion = null;

  constructor(private sEducacion: SEducacionService, 
              private activatedRoute: ActivatedRoute, 
              private router: Router, 
              public imageServiceLogo: ImageService) { }

  ngOnInit(): void {
    
    const id = this.activatedRoute.snapshot.params['id'];
    this.sEducacion.detail(id).subscribe(
      data => {
        this.educ = data;
      }, err => {
        alert("Error al modificar educacion");
        this.router.navigate(['']);
      }
    )

  }

  onUpdate(): void {

    const id = this.activatedRoute.snapshot.params['id'];
    this.educ.logoEdu = this.imageServiceLogo.url;
    this.sEducacion.update(id, this.educ).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar educacion");
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
