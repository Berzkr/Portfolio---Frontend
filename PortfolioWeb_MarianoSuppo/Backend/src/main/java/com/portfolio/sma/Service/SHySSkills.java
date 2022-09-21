package com.portfolio.sma.Service;

import com.portfolio.sma.Entity.HySSkills;
import com.portfolio.sma.Repository.RHySSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional //es para mantener la persistencia
public class SHySSkills {
    
    @Autowired
    RHySSkills rHyS;
    
    public List<HySSkills> list() {
        
        return rHyS.findAll();
        
    }
    //se utiliza el Optional porque el objeto puede estar o no
    public Optional<HySSkills> getOne (int id) {
        
        return rHyS.findById(id);
        
    }
    
    public Optional<HySSkills> getByNombreHyS (String nombreHyS) {
        
        return rHyS.findByNombreHyS(nombreHyS);
        
    }
    
    public void save (HySSkills hySSkills) {
        
        rHyS.save(hySSkills);
        
    }
    
    public void delete (int id) {
        
        rHyS.deleteById(id);
        
    }
    
    public boolean existsById (int id) {
        
        return rHyS.existsById(id);
        
    }
    
    public boolean existsByNombreHyS (String nombreHyS) {
        
        return rHyS.existsByNombreHyS(nombreHyS);
        
    }
    
}
