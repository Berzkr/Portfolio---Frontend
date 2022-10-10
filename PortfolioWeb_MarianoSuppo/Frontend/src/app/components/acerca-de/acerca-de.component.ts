import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona.model';
import { SvPersonaService } from 'src/app/service/sv-persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {

  persona: Persona = null;

  constructor(public personaService: SvPersonaService, private tokenService: TokenService) {

  }

  isLogged = false;

  ngOnInit(): void {

    this.cargarPersona();
    
    if (this.tokenService.getToken()) {
      
      this.isLogged = true;

    } else {

      this.isLogged = false;

    }
  
  }

  cargarPersona() {
    this.personaService.detail(1).subscribe(data =>
        {
          this.persona = data
        }
      )
  }

}
