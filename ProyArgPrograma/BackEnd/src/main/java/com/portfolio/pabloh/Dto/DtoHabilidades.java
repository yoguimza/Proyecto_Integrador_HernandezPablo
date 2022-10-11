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
public class DtoHabilidades {
    @NotBlank
    private String nombreH;
    @NotBlank
    private int valorH;

    public DtoHabilidades() {
    }

    public DtoHabilidades(String nombreH, int valorH) {
        this.nombreH = nombreH;
        this.valorH = valorH;
    }    

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public int getValorH() {
        return valorH;
    }

    public void setValorH(int valorH) {
        this.valorH = valorH;
    }   
}
