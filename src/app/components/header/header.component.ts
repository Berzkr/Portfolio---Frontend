import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/model/persona.model';
import { SvPersonaService } from 'src/app/service/sv-persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  persona: Persona = null;
  isLogged = false;

  constructor(private router:Router, private tokenService: TokenService, public personaService: SvPersonaService) { }

  ngOnInit(): void {
    
    this.cargarPersona();

    if (this.tokenService.getToken()) {

      this.isLogged = true;
      
    } else {

      this.isLogged = false;

    }

  }

  onLogOut(): void {

    this.tokenService.logOut();
    window.location.reload();

  }

  login(){

    this.router.navigate(['/login']);

  }

  cargarPersona() {
    this.personaService.detail(1).subscribe(data =>
        {
          this.persona = data
        }
      )
  }
  
}
