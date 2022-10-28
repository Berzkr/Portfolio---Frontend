import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { ImageService } from 'src/app/service/image.service';
import { SSkillService } from 'src/app/service/s-skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-edit-skill',
  templateUrl: './edit-skill.component.html',
  styleUrls: ['./edit-skill.component.css']
})
export class EditSkillComponent implements OnInit {

  skill: Skill = null;

  constructor(private sSkill: SSkillService, 
              private activatedRoute: ActivatedRoute, 
              private router: Router,
              public imageServiceLogoS: ImageService,
              private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    
    const id = this.activatedRoute.snapshot.params['id'];

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.imageServiceLogoS.clearUrl();

    this.sSkill.detail(id).subscribe(
      data => {
        this.skill = data;
      }, err => {
        alert("Error al modificar Skill");
        this.router.navigate(['']);
      }
    )

  }

  onUpdate() {

    const id = this.activatedRoute.snapshot.params['id'];
    if(this.imageServiceLogoS.url != "") {
      this.skill.imagenHyS = this.imageServiceLogoS.url;
    }
    this.sSkill.update(id, this.skill).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar Skill");
        this.router.navigate(['']);
      }
    );

  }

  uploadImage($event:any) {

    const carpeta = "imagenSkill"
    this.imageServiceLogoS.uploadImage($event, carpeta);

  }


}
