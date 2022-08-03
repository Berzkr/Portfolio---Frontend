package com.portfolio.sma.Controller;

import com.portfolio.sma.Entity.Persona;
import com.portfolio.sma.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//cross origin es para aceptar los llamados que le voy a hacer desde la url del frontend
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping ("/personas/traer")
    public List<Persona> getPersona(){
        
        return ipersonaService.getPersona();
        
    }
    
    @PostMapping ("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
        
    }
    
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
        
    }
    
    //URL:PUERTO/personas/editar/id?nombre=nuevoNombre&apellido=nuevoApellido&img=nuevoImg
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg) {
        
       Persona persona = ipersonaService.findPersona(id);
       
       persona.setNombre(nuevoNombre);
       persona.setApellido(nuevoApellido);
       persona.setImg(nuevoImg);
       
       ipersonaService.savePersona(persona);
       return persona;
        
    }
    
    //esto lo agrego aca para que cuando llamo perfil desde el frontend me lleve a
    //la primera persona de la base de datos que soy yo el propietario del portfolio
    @GetMapping ("/personas/traer/perfil")
    public Persona findPersona(){
        
        return ipersonaService.findPersona(1L);
        
    }
    
        
}
