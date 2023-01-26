import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { ImageService } from 'src/app/service/image.service';
import { SSkillService } from 'src/app/service/s-skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent implements OnInit {

  nombreHyS: string;
  porcentajeHyS: number;
  imagenHyS: string;

  constructor(private sSkill: SSkillService, 
              private router: Router,
              public imageServiceLogoS: ImageService,
              private tokenService: TokenService) { }

  isLogged = false;
  
  ngOnInit(): void {

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.imageServiceLogoS.clearUrl();

  }

  onCreate(): void {

    this.imagenHyS = this.imageServiceLogoS.url;
    const skill = new Skill(this.nombreHyS, this.porcentajeHyS, this.imagenHyS);
    this.sSkill.save(skill).subscribe(
      data => {
        alert("Skill creada correctamente");
        this.router.navigate(['']);
      }, err => {
        alert("Falló al añadir skill");
        this.router.navigate(['']);
      }
    )

  }

  uploadImage($event:any) {

    const carpeta = "imagenSkill"
    this.imageServiceLogoS.uploadImage($event, carpeta);

  }

  
}
