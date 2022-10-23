
package com.portfolio.sma.Controller;

import com.portfolio.sma.Dto.DtoHySSkills;
import com.portfolio.sma.Entity.HySSkills;
import com.portfolio.sma.Security.Controller.Mensaje;
import com.portfolio.sma.Service.SHySSkills;
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
@RequestMapping ("/hys")
//@CrossOrigin (origins = "http://localhost:4200")
@CrossOrigin (origins = "https://frontendmas-4014a.web.app")
public class CHySSkills {
    
    @Autowired
    SHySSkills sHyS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HySSkills>> list() {
        
        List<HySSkills> list = sHyS.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @PostMapping ("/create")
    //el signo ? indica que response entity puede recibir cualquier cosa
    public ResponseEntity<?> create (@RequestBody DtoHySSkills dtoHyS) {
        //si el campo es blanco salta el error
        if(StringUtils.isBlank(dtoHyS.getNombreHyS())) {
            
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        //esta validacion es por si la hys que se quiere agregar ya existe salta el error
        if(sHyS.existsByNombreHyS(dtoHyS.getNombreHyS())) {
            
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        HySSkills hySSkills = new HySSkills(dtoHyS.getNombreHyS(), dtoHyS.getPorcentajeHyS(), dtoHyS.getImagenHyS());
        sHyS.save(hySSkills);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHySSkills dtoHyS) {
        //validamos si existe el ID
        if(!sHyS.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
            
        }
        //comparo los nombres de las hys que quiero agregar con las que ya existen en la base de datos
        if(sHyS.existsByNombreHyS(dtoHyS.getNombreHyS()) && sHyS.getByNombreHyS(dtoHyS.getNombreHyS()).get().getId() != id) {
            
            return new ResponseEntity(new Mensaje("Ese nombre de Skill ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        //el campo no puede estar vacio
        if(StringUtils.isBlank(dtoHyS.getNombreHyS())) {
            
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
            
        }
        
        HySSkills hySSkills = sHyS.getOne(id).get();
        //busca el nombre, el porcentaje e imagen que esta en el dto y lo setea a hySSkills
        hySSkills.setNombreHyS(dtoHyS.getNombreHyS());
        hySSkills.setPorcentajeHyS(dtoHyS.getPorcentajeHyS());
        hySSkills.setImagenHyS(dtoHyS.getImagenHyS());
        
        sHyS.save(hySSkills);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id) {
        
        if(!sHyS.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
            
        }
        
        sHyS.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HySSkills> getById(@PathVariable("id") int id){
        
        if(!sHyS.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        
        }
        
        HySSkills hySSkills = sHyS.getOne(id).get();
        return new ResponseEntity(hySSkills, HttpStatus.OK);
    
    }
    
}
