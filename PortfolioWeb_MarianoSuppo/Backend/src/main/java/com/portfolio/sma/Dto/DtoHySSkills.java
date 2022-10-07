package com.portfolio.sma.Dto;

import javax.validation.constraints.NotBlank;


public class DtoHySSkills {
    
    @NotBlank
    private String nombreHyS;
    @NotBlank
    private int porcentajeHyS;
    @NotBlank
    private String imagenHyS;

    //constructores
    public DtoHySSkills() {
    }

    public DtoHySSkills(String nombreHyS, int porcentajeHyS, String imagenHyS) {
        this.nombreHyS = nombreHyS;
        this.porcentajeHyS = porcentajeHyS;
        this.imagenHyS = imagenHyS;
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

    public String getImagenHyS() {
        return imagenHyS;
    }

    public void setImagenHyS(String imagenHyS) {
        this.imagenHyS = imagenHyS;
    }
    
    
}
