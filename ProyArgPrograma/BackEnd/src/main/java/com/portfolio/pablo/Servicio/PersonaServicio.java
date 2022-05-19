/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pablo.Servicio;

import com.portfolio.pablo.Entidad.Persona;
import com.portfolio.pablo.Interface.IPersonaServicio;
import com.portfolio.pablo.Repositorio.IPersonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Notebook
 */
@Service
public class PersonaServicio implements IPersonaServicio{
@Autowired IPersonaRepositorio ipersonaRepository;
        
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void guardaPersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void borraPersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona buscaPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
