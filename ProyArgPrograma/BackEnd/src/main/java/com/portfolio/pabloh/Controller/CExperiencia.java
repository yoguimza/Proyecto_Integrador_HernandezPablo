/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Controller;


import com.portfolio.pabloh.Dto.DtoExperiencia;
import com.portfolio.pabloh.Entity.Experiencia;
import com.portfolio.pabloh.Security.Controller.Mensaje;
import com.portfolio.pabloh.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Notebook
 */
@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "https://frontendpablo.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>>list(){
        List<Experiencia> list=sExperiencia.list();
        return new ResponseEntity(list,HttpStatus.OK);        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoExperiencia dtoexp){
        if (StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
        if (sExperiencia.existByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa Experiencia Existe"),HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia=new Experiencia(dtoexp.getNombreE(),dtoexp.getDescripcionE());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia agregada"),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id")int id, @RequestBody DtoExperiencia dtoexp ){
        //Validar si existe el ID
        if (!sExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if (sExperiencia.existByNombreE(dtoexp.getNombreE())&& sExperiencia.getByNombre(dtoexp.getNombreE()).get().getId()!=id) 
            return new ResponseEntity(new Mensaje("Esa Experiencia No Existe"),HttpStatus.BAD_REQUEST);
        // No puede estar vacio
        if (StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
        
        Experiencia experiencia=sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE((dtoexp.getDescripcionE()));
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        //Validar si existe el ID
        if (!sExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.BAD_REQUEST);       
       sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    }
    
    
    
    
    
    
    
}
