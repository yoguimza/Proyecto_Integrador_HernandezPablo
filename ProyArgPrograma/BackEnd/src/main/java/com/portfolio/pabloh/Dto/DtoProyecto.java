/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Notebook
 */
public class DtoProyecto {
    @NotBlank
    private String nombrePr;
    @NotBlank
    private String descripcionPr;
    @NotBlank
    private String fotoPr;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombrePr, String descripcionPr, String fotoPr) {
        this.nombrePr = nombrePr;
        this.descripcionPr = descripcionPr;
        this.fotoPr = fotoPr;
    }

    public String getNombrePr() {
        return nombrePr;
    }

    public void setNombrePr(String nombrePr) {
        this.nombrePr = nombrePr;
    }

    public String getDescripcionPr() {
        return descripcionPr;
    }

    public void setDescripcionPr(String descripcionPr) {
        this.descripcionPr = descripcionPr;
    }

    public String getFotoPr() {
        return fotoPr;
    }

    public void setFotoPr(String fotoPr) {
        this.fotoPr = fotoPr;
    }
    
}
