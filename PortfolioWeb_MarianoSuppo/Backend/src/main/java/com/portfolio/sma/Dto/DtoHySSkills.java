package com.portfolio.sma.Dto;

import javax.validation.constraints.NotBlank;


public class DtoHySSkills {
    
    @NotBlank
    private String nombreHyS;
    @NotBlank
    private int porcentajeHyS;

    //constructores
    public DtoHySSkills() {
    }

    public DtoHySSkills(String nombreHyS, int porcentajeHyS) {
        this.nombreHyS = nombreHyS;
        this.porcentajeHyS = porcentajeHyS;
    }
       
    //Getters & Setters
    public String getNombreHyS() {
        return nombreHyS;
    }

    public void setNombreHyS(String nombreHyS) {
        this.nombreHyS = nombreHyS;
    }

    public int getPorcentajeHyS() {
        return porcentajeHyS;
    }

    public void setPorcentajeHyS(int porcentajeHyS) {
        this.porcentajeHyS = porcentajeHyS;
    }
    
    
}
