package com.portfolio.sma.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String descripcionEdu;
    private String fechaInicioEdu;
    private String fechaFinEdu;
    private String logoEdu;


    //constructores
    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripcionEdu, String fechaInicioEdu, String fechaFinEdu, String logoEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaFinEdu = fechaFinEdu;
        this.logoEdu = logoEdu;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
