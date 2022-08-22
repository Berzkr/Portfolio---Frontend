package com.portfolio.sma.Service;

import com.portfolio.sma.Entity.Educacion;
import com.portfolio.sma.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //es para mantener la persistencia
public class SEducacion {
    
     
    @Autowired
    REducacion rEducacion;
    
    public List<Educacion> list() {
        
        return rEducacion.findAll();
        
    }
    //se utiliza el Optional porque el objeto puede estar o no
    public Optional<Educacion> getOne (int id) {
        
        return rEducacion.findById(id);
        
    }
    
    public Optional<Educacion> getByNombreEdu (String nombreEdu) {
        
        return rEducacion.findByNombreEdu(nombreEdu);
        
    }
    
    public void save (Educacion edu) {
        
        rEducacion.save(edu);
        
    }
    
    public void delete (int id) {
        
        rEducacion.deleteById(id);
        
    }
    
    public boolean existsById (int id) {
        
        return rEducacion.existsById(id);
        
    }
    
    public boolean existsByNombreEdu (String nombreEdu) {
        
        return rEducacion.existsByNombreEdu(nombreEdu);
        
    }
    
}
