
package com.portfolio.sma.Dto;

import javax.validation.constraints.NotBlank;


public class DtoEducacion {
    
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private String fechaInicioEdu;
    @NotBlank
    private String fechaFinEdu;
    @NotBlank
    private String logoEdu;

    //constructores
    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEdu, String descripcionEdu, String fechaInicioEdu, String fechaFinEdu, String logoEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaFinEdu = fechaFinEdu;
        this.logoEdu = logoEdu;
    }
         
    //Getters & Setters
    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getFechaInicioEdu() {
        return fechaInicioEdu;
    }

    public void setFechaInicioEdu(String fechaInicioEdu) {
        this.fechaInicioEdu = fechaInicioEdu;
    }

    public String getFechaFinEdu() {
        return fechaFinEdu;
    }

    public void setFechaFinEdu(String fechaFinEdu) {
        this.fechaFinEdu = fechaFinEdu;
    }

    public String getLogoEdu() {
        return logoEdu;
    }

    public void setLogoEdu(String logoEdu) {
        this.logoEdu = logoEdu;
    }
       
}
