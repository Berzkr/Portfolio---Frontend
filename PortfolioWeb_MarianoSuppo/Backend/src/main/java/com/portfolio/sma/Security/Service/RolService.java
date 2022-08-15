package com.portfolio.sma.Security.Service;

import com.portfolio.sma.Security.Entity.Rol;
import com.portfolio.sma.Security.Enums.RolNombre;
import com.portfolio.sma.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional  //trata de mantener los mismos datos de aca con la base de datos
public class RolService {
    
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        
        return irolRepository.findByRolNombre(rolNombre);
        
    }
    
    public void save(Rol rol) {
        
        irolRepository.save(rol);
        
    }
    
}
