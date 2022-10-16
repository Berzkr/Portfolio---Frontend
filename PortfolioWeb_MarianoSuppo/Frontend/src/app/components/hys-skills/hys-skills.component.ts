import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/model/skill';
import { SSkillService } from 'src/app/service/s-skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hys-skills',
  templateUrl: './hys-skills.component.html',
  styleUrls: ['./hys-skills.component.css']
})
export class HysSkillsComponent implements OnInit {

  skill: Skill[] = [];

  constructor(private sSkill: SSkillService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {

    this.cargarSkill();
    
    if (this.tokenService.getToken()) {
      
      this.isLogged = true;

    } else {

      this.isLogged = false;

    }

  }

  cargarSkill(): void {

    this.sSkill.lista().subscribe(data => {this.skill = data;});
    
  }

  delete(id?: number) {

    const respuesta = confirm ("¿Estas seguro que deseas eliminar esta Skill?");
    if (respuesta == true){
      if (id != undefined) {
        this.sSkill.delete(id).subscribe(
          data => {
            this.cargarSkill();
          }, err => {
            alert("No se pudo eliminar Skill");
          }
        )
        alert("Skill Borrada");
      }
    }
  }

}
