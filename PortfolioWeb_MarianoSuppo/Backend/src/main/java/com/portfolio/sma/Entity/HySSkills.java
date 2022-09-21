package com.portfolio.sma.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class HySSkills {
        
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHyS;  //una vez que aprenda agregaré las imágenes
    private int porcentajeHyS;

    public HySSkills() {
    }

    public HySSkills(String nombreHyS, int porcentajeHyS) {
        this.nombreHyS = nombreHyS;
        this.porcentajeHyS = porcentajeHyS;
    }
   
}
