/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Service;

import com.portfolio.pabloh.Entity.Habilidades;
import com.portfolio.pabloh.Repository.RHabilidades;
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
public class SHabilidades {
    @Autowired
    RHabilidades rHabilidades;
    public List<Habilidades> list(){
        return rHabilidades.findAll();        
    }
    
    public Optional <Habilidades>getOne(int id){
        return rHabilidades.findById(id);
    }
    
    public Optional <Habilidades>getByNombreH(String nombreH){
        return rHabilidades.findByNombreH(nombreH);
    }
    
    public void save(Habilidades habi){
        rHabilidades.save(habi);
    }
    
    public void delete(int id){
        rHabilidades.deleteById(id);
    }
    
    public boolean existById(int id){
        return rHabilidades.existsById(id);
    }
    
    public boolean existByNombreH(String nombreH){
        return rHabilidades.existsByNombreH(nombreH);
    }
    
}
