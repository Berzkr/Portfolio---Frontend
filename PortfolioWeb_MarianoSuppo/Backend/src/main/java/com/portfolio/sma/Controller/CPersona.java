package com.portfolio.sma.Controller;

import com.portfolio.sma.Dto.DtoPersona;
import com.portfolio.sma.Entity.Persona;
import com.portfolio.sma.Security.Controller.Mensaje;
import com.portfolio.sma.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
//cross origin es para aceptar los llamados que le voy a hacer desde la url del frontend
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin (origins = "https://frontendmas-4014a.web.app")
public class CPersona {
    
    @Autowired
    SPersona sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    /*@PostMapping ("/create")
    //el signo ? indica que response entity puede recibir cualquier cosa
    public ResponseEntity<?> create (@RequestBody DtoPersona dtoPerso) {
        //si el campo es blanco salta el error
        if(StringUtils.isBlank(dtoPerso.getNombre())) {
            
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        //esta validacion es por si la persona que se quiere agregar ya existe salta el error
        if(sPersona.existsByNombre(dtoPerso.getNombre())) {
            
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        Persona persona = new Persona(dtoPerso.getNombre(),
                                      dtoPerso.getApellido(), 
                                      dtoPerso.getAcercaDe(), 
                                      dtoPerso.getImg(),
                                      dtoPerso.getBanner(),
                                      dtoPerso.getFace(),
                                      dtoPerso.getInsta(),
                                      dtoPerso.getTwit(),
                                      dtoPerso.getLinked(),
                                      dtoPerso.getGit());
        sPersona.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    
    }*/
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPerso) {
        //validamos si existe el ID
        if(!sPersona.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
            
        }
        //comparo los nombres de las personas que quiero agregar con las que ya existen en la base de datos
        if(sPersona.existsByNombre(dtoPerso.getNombre()) && sPersona.getByNombre(dtoPerso.getNombre()).get().getId() != id) {
            
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        //el campo no puede estar vacio
        if(StringUtils.isBlank(dtoPerso.getNombre())) {
            
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
            
        }
        
        Persona persona = sPersona.getOne(id).get();
        //busca el nombre, apellido, acercade e img, redes sociales y banner que esta en el dto y lo setea a persona
        persona.setNombre(dtoPerso.getNombre());
        persona.setApellido(dtoPerso.getApellido());
        persona.setAcercaDe(dtoPerso.getAcercaDe());
        persona.setImg(dtoPerso.getImg());
        persona.setBanner(dtoPerso.getBanner());
        persona.setFace(dtoPerso.getFace());
        persona.setInsta(dtoPerso.getInsta());
        persona.setTwit(dtoPerso.getTwit());
        persona.setLinked(dtoPerso.getLinked());
        persona.setGit(dtoPerso.getGit());
        
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
        
    }
    
    /*@DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id) {
        
        if(!sPersona.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
            
        }
        
        sPersona.delete(id);
        
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
        
    }*/
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        
        if(!sPersona.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        
        }
        
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    
    }
}
