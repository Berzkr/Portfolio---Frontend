package com.portfolio.sma.Repository;

import com.portfolio.sma.Entity.HySSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHySSkills extends JpaRepository<HySSkills, Integer>{
    
    public Optional<HySSkills> findByNombreHyS (String nombreHyS);
    
    public boolean existsByNombreHyS (String nombreHyS);
    
}
