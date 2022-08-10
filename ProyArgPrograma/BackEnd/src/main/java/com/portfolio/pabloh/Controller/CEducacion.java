/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Controller;

import com.portfolio.pabloh.Dto.DtoEducacion;
import com.portfolio.pabloh.Entity.Educacion;
import com.portfolio.pabloh.Security.Controller.Mensaje;
import com.portfolio.pabloh.Service.SEducacion;
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
@RequestMapping("educ")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>>list(){
        List<Educacion> list=sEducacion.list();
        return new ResponseEntity(list,HttpStatus.OK);        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoEducacion dtoedu){
        if (StringUtils.isBlank(dtoedu.getNombreEd()))
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
        if (sEducacion.existByNombreEd(dtoedu.getNombreEd()))
            return new ResponseEntity(new Mensaje("Esa Educacion Existe"),HttpStatus.BAD_REQUEST);
        
        Educacion educacion=new Educacion(dtoedu.getNombreEd(),dtoedu.getDescripcionEd());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada"),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id")int id, @RequestBody DtoEducacion dtoedu ){
        //Validar si existe el ID
        if (!sEducacion.existById(id))
            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.NOT_FOUND);
        //Compara nombre de educacion
        if (sEducacion.existByNombreEd(dtoedu.getNombreEd())&& sEducacion.getByNombreEd(dtoedu.getNombreEd()).get().getId()!=id) 
            return new ResponseEntity(new Mensaje("Esa Educacion No Existe"),HttpStatus.NOT_FOUND);
        // No puede estar vacio
        if (StringUtils.isBlank(dtoedu.getNombreEd()))
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
        
        Educacion educacion=sEducacion.getOne(id).get();
        educacion.setNombreEd(dtoedu.getNombreEd());
        educacion.setDescripcionEd((dtoedu.getDescripcionEd()));
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        //Validar si existe el ID
        if (!sEducacion.existById(id))
            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.BAD_REQUEST);       
       sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    }
    
    
    
    
}
