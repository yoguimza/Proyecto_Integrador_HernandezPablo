/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Notebook
 */
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombrePr;
    private String descripcionPr;
    private String fotoPr;
    

    public Proyecto() {
    }

    public Proyecto(String nombrePr, String descripcionPr, String fotoPr) {
        this.nombrePr = nombrePr;
        this.descripcionPr = descripcionPr;
        this.fotoPr = fotoPr;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
