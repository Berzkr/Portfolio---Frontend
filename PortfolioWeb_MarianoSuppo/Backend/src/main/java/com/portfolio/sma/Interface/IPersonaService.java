package com.portfolio.sma.Interface;

import com.portfolio.sma.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    
    //traer una lista de personas
    public List<Persona> getPersona();
    
    //guardar un objeto del tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto pero lo buscamos por Id
    public void deletePersona(Long id);
    
    //buscar una persona por ID
    public Persona findPersona(Long id);
    
}
