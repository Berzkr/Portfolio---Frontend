package com.portfolio.sma.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String apellido;
    @NotNull
    private String acercaDe;
    private String img;
    
    //constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, String acercaDe, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acercaDe = acercaDe;
        this.img = img;
    }
   
}
