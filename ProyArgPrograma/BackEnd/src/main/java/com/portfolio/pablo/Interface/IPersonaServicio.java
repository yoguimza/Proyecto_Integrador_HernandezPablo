/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.pablo.Interface;

import com.portfolio.pablo.Entidad.Persona;
import java.util.List;

/**
 *
 * @author Notebook
 */
public interface IPersonaServicio {
    //Traer lista de personas
    public List<Persona> getPersona();
    //Guardar una Persona
    public void guardaPersona(Persona persona);
    //Borrar una Persona
    public void borraPersona(Long id);
    //Buscar una Persona por ID
    public Persona buscaPersona(Long id);
    
}
