package com.portfolio.sma.Service;

import com.portfolio.sma.Entity.Proyecto;
import com.portfolio.sma.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //es para mantener la persistencia
public class SProyecto {
    
    @Autowired
    RProyecto rProyecto;
    
    public List<Proyecto> list() {
        
        return rProyecto.findAll();
        
    }
    //se utiliza el Optional porque el objeto puede estar o no
    public Optional<Proyecto> getOne (int id) {
        
        return rProyecto.findById(id);
        
    }
    
    public Optional<Proyecto> getByNombreP (String nombreP) {
        
        return rProyecto.findByNombreP(nombreP);
        
    }
    
    public void save (Proyecto proy) {
        
        rProyecto.save(proy);
        
    }
    
    public void delete (int id) {
        
        rProyecto.deleteById(id);
        
    }
    
    public boolean existsById (int id) {
        
        return rProyecto.existsById(id);
        
    }
    
    public boolean existsByNombreP (String nombreP) {
        
        return rProyecto.existsByNombreP(nombreP);
        
    }
    
}
