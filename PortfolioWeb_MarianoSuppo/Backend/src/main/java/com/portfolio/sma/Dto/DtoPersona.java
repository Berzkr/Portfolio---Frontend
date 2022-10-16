package com.portfolio.sma.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoPersona {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String acercaDe;
    @NotBlank
    private String img;
    private String banner;
    private String face;
    private String insta;
    private String twit;
    private String linked;
    private String git;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String acercaDe, String img, String banner, String face, String insta, String twit, String linked, String git) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acercaDe = acercaDe;
        this.img = img;
        this.banner = banner;
        this.face = face;
        this.insta = insta;
        this.twit = twit;
        this.linked = linked;
        this.git = git;
    }
    
}
