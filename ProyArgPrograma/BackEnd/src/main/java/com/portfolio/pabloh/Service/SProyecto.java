/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Service;

import com.portfolio.pabloh.Entity.Proyecto;
import com.portfolio.pabloh.Repository.RProyecto;
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
public class SProyecto {
    @Autowired
    RProyecto rproyecto;
    public List<Proyecto> list(){
        return rproyecto.findAll();        
    }
    
    public Optional <Proyecto>getOne(int id){
        return rproyecto.findById(id);
    }
    
    public Optional <Proyecto>getByNombrePr(String nombrePr){
        return rproyecto.findByNombrePr(nombrePr)
                ;
    }
    
    public void save(Proyecto proye){
        rproyecto.save(proye);
    }
    
    public void delete(int id){
        rproyecto.deleteById(id);
    }
    
    public boolean existById(int id){
        return rproyecto.existsById(id);
    }
    
    public boolean existByNombrePr(String nombrePr){
        return rproyecto.existsByNombrePr(nombrePr);
    }
    
    
}
