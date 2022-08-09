/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Service;

import com.portfolio.pabloh.Entity.Experiencia;
import com.portfolio.pabloh.Repository.RExperiencia;
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
public class SExperiencia {
    @Autowired
    RExperiencia rExperiiencia;
    public List<Experiencia> list(){
        return rExperiiencia.findAll();        
    }
    
    public Optional <Experiencia>getOne(int id){
        return rExperiiencia.findById(id);
    }
    
    public Optional <Experiencia>getByNombre(String nombreE){
        return rExperiiencia.findByNombreE(nombreE);
    }
    
    public void save(Experiencia expe){
        rExperiiencia.save(expe);
    }
    
    public void delete(int id){
        rExperiiencia.deleteById(id);
    }
    
    public boolean existById(int id){
        return rExperiiencia.existsById(id);
    }
    
    public boolean existByNombreE(String nombreE){
        return rExperiiencia.existsByNombreE(nombreE);
    }
    
    
    
    
}
