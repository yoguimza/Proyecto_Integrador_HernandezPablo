/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Service;

import com.portfolio.pabloh.Entity.Persona;
import com.portfolio.pabloh.Interface.iPersonaService;
import com.portfolio.pabloh.Repository.iPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Notebook
 */
@Service
public class ImplPersonaService implements iPersonaService {
    @Autowired iPersonaRepository ipersonarepository;

    
    
    @Override
    public List<Persona> getPersona() {
        List <Persona> persona = ipersonarepository.findAll();
                return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonarepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonarepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonarepository.findById(id).orElse(null);
        return persona;
        
    }
    
}
