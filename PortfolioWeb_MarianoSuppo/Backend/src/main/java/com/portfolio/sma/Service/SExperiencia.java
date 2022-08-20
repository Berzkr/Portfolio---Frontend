
package com.portfolio.sma.Service;

import com.portfolio.sma.Entity.Experiencia;
import com.portfolio.sma.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //es para mantener la persistencia
public class SExperiencia {
    
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list() {
        
        return rExperiencia.findAll();
        
    }
    //se utiliza el Optional porque el objeto puede estar o no
    public Optional<Experiencia> getOne (int id) {
        
        return rExperiencia.findById(id);
        
    }
    
    public Optional<Experiencia> getByNombreE (String nombreE) {
        
        return rExperiencia.findByNombreE(nombreE);
        
    }
    
    public void save (Experiencia expe) {
        
        rExperiencia.save(expe);
        
    }
    
    public void delete (int id) {
        
        rExperiencia.deleteById(id);
        
    }
    
    public boolean existsById (int id) {
        
        return rExperiencia.existsById(id);
        
    }
    
    public boolean existsByNombreE (String nombreE) {
        
        return rExperiencia.existsByNombreE(nombreE);
        
    }
    
}
