package com.portfolio.sma.Controller;

import com.portfolio.sma.Dto.DtoEducacion;
import com.portfolio.sma.Entity.Educacion;
import com.portfolio.sma.Security.Controller.Mensaje;
import com.portfolio.sma.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/educacion")
@CrossOrigin (origins = "http://localhost:4200")
public class CEducacion {
    
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @PostMapping ("/create")
    //el signo ? indica que response entity puede recibir cualquier cosa
    public ResponseEntity<?> create (@RequestBody DtoEducacion dtoEdu) {
        //si el campo es blanco salta el error
        if(StringUtils.isBlank(dtoEdu.getNombreEdu())) {
            
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        //esta validacion es por si la educacion que se quiere agregar ya existe salta el error
        if(sEducacion.existsByNombreEdu(dtoEdu.getNombreEdu())) {
            
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        Educacion educacion = new Educacion(dtoEdu.getNombreEdu(), dtoEdu.getDescripcionEdu(), dtoEdu.getFechaInicioEdu(), dtoEdu.getFechaFinEdu(), dtoEdu.getLogoEdu());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
    
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEdu) {
        //validamos si existe el ID
        if(!sEducacion.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
            
        }
        //comparo los nombres de las educaciones que quiero agregar con las que ya existen en la base de datos
        if(sEducacion.existsByNombreEdu(dtoEdu.getNombreEdu()) && sEducacion.getByNombreEdu(dtoEdu.getNombreEdu()).get().getId() != id) {
            
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        //el campo no puede estar vacio
        if(StringUtils.isBlank(dtoEdu.getNombreEdu())) {
            
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
            
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        //busca el nombre y la descripcion que esta en el dto y lo setea a educacion
        educacion.setNombreEdu(dtoEdu.getNombreEdu());
        educacion.setDescripcionEdu(dtoEdu.getDescripcionEdu());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id) {
        
        if(!sEducacion.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
            
        }
        
        sEducacion.delete(id);
        
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        
        if(!sEducacion.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    
    }
    
}
