import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona.model';
import { SvPersonaService } from 'src/app/service/sv-persona.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {

  persona: Persona = new Persona("","","");

  constructor(public personaService: SvPersonaService) {

  }

  ngOnInit(): void {

    this.personaService.getPersona().subscribe(data => {this.persona = data});

  }

}
