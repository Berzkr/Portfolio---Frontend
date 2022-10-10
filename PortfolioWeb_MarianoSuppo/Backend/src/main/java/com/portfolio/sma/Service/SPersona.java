package com.portfolio.sma.Service;

import com.portfolio.sma.Entity.Persona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.sma.Repository.RPersona;

@Service
@Transactional
public class SPersona{
    
    @Autowired 
    RPersona ipersonaRepository;

    public List<Persona> list() {
        
        return ipersonaRepository.findAll();
        
    }
    //se utiliza el Optional porque el objeto puede estar o no
    public Optional<Persona> getOne (int id) {
        
        return ipersonaRepository.findById(id);
        
    }
    
    public Optional<Persona> getByNombre (String nombre) {
        
        return ipersonaRepository.findByNombre(nombre);
        
    }
    
    public void save (Persona persona) {
        
        ipersonaRepository.save(persona);
        
    }
    
    public void delete (int id) {
        
        ipersonaRepository.deleteById(id);
        
    }
    
    public boolean existsById (int id) {
        
        return ipersonaRepository.existsById(id);
        
    }
    
    public boolean existsByNombre (String nombre) {
        
        return ipersonaRepository.existsByNombre(nombre);
        
    }
    
}
