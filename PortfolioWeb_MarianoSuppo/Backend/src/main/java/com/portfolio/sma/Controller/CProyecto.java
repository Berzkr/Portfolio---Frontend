package com.portfolio.sma.Controller;

import com.portfolio.sma.Dto.DtoProyecto;
import com.portfolio.sma.Entity.Proyecto;
import com.portfolio.sma.Security.Controller.Mensaje;
import com.portfolio.sma.Service.SProyecto;
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
@RequestMapping ("/proyecto")
@CrossOrigin (origins = "http://localhost:4200")
public class CProyecto {
    
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @PostMapping ("/create")
    //el signo ? indica que response entity puede recibir cualquier cosa
    public ResponseEntity<?> create (@RequestBody DtoProyecto dtoProy) {
        //si el campo es blanco salta el error
        if(StringUtils.isBlank(dtoProy.getNombreP())) {
            
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        //esta validacion es por si el proyecto que se quiere agregar ya existe salta el error
        if(sProyecto.existsByNombreP(dtoProy.getNombreP())) {
            
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        Proyecto proyecto = new Proyecto(dtoProy.getNombreP(), dtoProy.getDescripcionP(), dtoProy.getImagenP(), dtoProy.getFechaP(), dtoProy.getLinkP());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProy) {
        //validamos si existe el ID
        if(!sProyecto.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
            
        }
        //comparo los nombres de los Proyectos que quiero agregar con los que ya existen en la base de datos
        if(sProyecto.existsByNombreP(dtoProy.getNombreP()) && sProyecto.getByNombreP(dtoProy.getNombreP()).get().getId() != id) {
            
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
            
        }
        //el campo no puede estar vacio
        if(StringUtils.isBlank(dtoProy.getNombreP())) {
            
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
            
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        //busca el nombre, la descripcion, la imagen, la fecha y el link que esta en el dto y lo setea a proyecto
        proyecto.setNombreP(dtoProy.getNombreP());
        proyecto.setDescripcionP(dtoProy.getDescripcionP());
        proyecto.setImagenP(dtoProy.getImagenP());
        proyecto.setFechaP(dtoProy.getFechaP());
        proyecto.setLinkP(dtoProy.getLinkP());
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
        
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id) {
        
        if(!sProyecto.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
            
        }
        
        sProyecto.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        
        if(!sProyecto.existsById(id)) {
            
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    
    }
    
}
