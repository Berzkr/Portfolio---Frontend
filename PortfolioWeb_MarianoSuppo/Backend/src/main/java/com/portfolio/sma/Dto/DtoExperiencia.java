package com.portfolio.sma.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String fechaInicioE;
    @NotBlank
    private String fechaFinE;
    @NotBlank
    private String logoE;

    //constructores
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descripcionE, String fechaInicioE, String fechaFinE, String logoE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaInicioE = fechaInicioE;
        this.fechaFinE = fechaFinE;
        this.logoE = logoE;
    }
  

    //Getters & Setters
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getFechaInicioE() {
        return fechaInicioE;
    }

    public void setFechaInicioE(String fechaInicioE) {
        this.fechaInicioE = fechaInicioE;
    }

    public String getFechaFinE() {
        return fechaFinE;
    }

    public void setFechaFinE(String fechaFinE) {
        this.fechaFinE = fechaFinE;
    }

    public String getLogoE() {
        return logoE;
    }

    public void setLogoE(String logoE) {
        this.logoE = logoE;
    }
            
}
