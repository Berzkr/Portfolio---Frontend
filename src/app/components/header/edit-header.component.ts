import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/model/persona.model';
import { ImageService } from 'src/app/service/image.service';
import { SvPersonaService } from 'src/app/service/sv-persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-edit-header',
  templateUrl: './edit-header.component.html',
  styleUrls: ['./edit-header.component.css']
})
export class EditHeaderComponent implements OnInit {

  persona: Persona = null;

  constructor(private sPersona: SvPersonaService, 
              private activatedRoute: ActivatedRoute, 
              private router: Router,
              public imageService: ImageService,
              private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.imageService.clearUrl();

    this.sPersona.detail(id).subscribe(
      data => {
        this.persona = data;
      }, err => {
        alert("Error al modificar persona");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate():void {
    const id = this.activatedRoute.snapshot.params['id'];
    if(this.imageService.url != "") {
      this.persona.banner = this.imageService.url;
    }
    this.sPersona.update(id, this.persona).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar persona");
        this.router.navigate(['']);
      }
    )
  }

  uploadImage($event:any) {

    const carpeta = "banner";
    this.imageService.uploadImage($event, carpeta);

  }

}
