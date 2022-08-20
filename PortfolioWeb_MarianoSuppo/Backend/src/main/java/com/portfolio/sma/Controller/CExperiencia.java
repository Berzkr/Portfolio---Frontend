
package com.portfolio.sma.Controller;

import com.portfolio.sma.Dto.DtoExperiencia;
import com.portfolio.sma.Entity.Experiencia;
import com.portfolio.sma.Security.Controller.Mensaje;
import com.portfolio.sma.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("explab")
@CrossOrigin (origins = "http://localhost:4200")
public class CExperiencia {
    
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @PostMapping ("/create")
    //el signo ? indica que response entity puede recibir cualquier cosa
    public ResponseEntity<?> create (@RequestBody DtoExperiencia dtoExp) {
        //si el campo es blanco salta el error
        if(StringUtils.isBlank(dtoExp.getNombreE())) {
            
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        //esta validacion es por si la experiencia que se quiere agregar ya existe salta el error
        if(sExperiencia.existsByNombreE(dtoExp.getNombreE())) {
            
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        Experiencia experiencia = new Experiencia(dtoExp.getNombreE(), dtoExp.getDescripcionE());
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExp) {
        //validamos si existe el ID
        if(!sExperiencia.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
            
        }
        //comparo los nombres de las experiencias que quiero agregar con las que ya existen en la base de datos
        if(sExperiencia.existsByNombreE(dtoExp.getNombreE()) && sExperiencia.getByNombreE(dtoExp.getNombreE()).get().getId() != id) {
            
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        //el campo no puede estar vacio
        if(StringUtils.isBlank(dtoExp.getNombreE())) {
            
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        //busca el nombre y la experiencia que esta en el dto y lo setea a experiencia
        experiencia.setNombreE(dtoExp.getNombreE());
        experiencia.setDescripcionE(dtoExp.getDescripcionE());
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id) {
        
        if(!sExperiencia.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
            
        }
        
        sExperiencia.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        
        if(!sExperiencia.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        }
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    
    }
    
}
