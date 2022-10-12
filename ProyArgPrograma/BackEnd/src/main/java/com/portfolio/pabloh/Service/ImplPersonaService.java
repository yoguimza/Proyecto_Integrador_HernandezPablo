/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Service;

import com.portfolio.pabloh.Entity.Persona;
import com.portfolio.pabloh.Repository.iPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Notebook
 */
@Service
@Transactional
public class ImplPersonaService{
    @Autowired iPersonaRepository ipersonarepository;
    public List<Persona> list(){
        return ipersonarepository.findAll();        
    }
    
    public Optional <Persona>getOne(int id){
        return ipersonarepository.findById(id);
    }
    
    public Optional <Persona>getByNombre(String nombre){
        return ipersonarepository.findByNombre(nombre);
    }
    
    public void save(Persona perso){
        ipersonarepository.save(perso);
    }
    
    public void delete(int id){
        ipersonarepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return ipersonarepository.existsById(id);
    }
    
    public boolean existByNombre(String nombre){
        return ipersonarepository.existsByNombre(nombre);
    }
 }