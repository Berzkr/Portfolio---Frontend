import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SSkillService } from 'src/app/service/s-skill.service';

@Component({
  selector: 'app-edit-skill',
  templateUrl: './edit-skill.component.html',
  styleUrls: ['./edit-skill.component.css']
})
export class EditSkillComponent implements OnInit {

  skill: Skill = null;

  constructor(private sSkill: SSkillService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    
    const id = this.activatedRoute.snapshot.params['id'];
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
    this.sSkill.update(id, this.skill).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar Skill");
        this.router.navigate(['']);
      }
    );

  }

}
