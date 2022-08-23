/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Controller;

import com.portfolio.pabloh.Dto.DtoEducacion;
import com.portfolio.pabloh.Dto.DtoHabilidades;
import com.portfolio.pabloh.Entity.Educacion;
import com.portfolio.pabloh.Entity.Habilidades;
import com.portfolio.pabloh.Security.Controller.Mensaje;
import com.portfolio.pabloh.Service.SHabilidades;
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
@RequestMapping("habili")
@CrossOrigin(origins = "https://frontendpablo.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidades {
    @Autowired
    SHabilidades sHabilidades;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>>list(){
        List<Habilidades> list=sHabilidades.list();
        return new ResponseEntity(list,HttpStatus.OK);        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        if(!sHabilidades.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidades habilidades = sHabilidades.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoHabilidades dtohabi){
        if (StringUtils.isBlank(dtohabi.getNombreH()))
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
        if (sHabilidades.existByNombreH(dtohabi.getNombreH()))
            return new ResponseEntity(new Mensaje("Esa Habilidad ya Existe"),HttpStatus.BAD_REQUEST);
        
        Habilidades habilidades=new Habilidades(dtohabi.getNombreH(),dtohabi.getValorH());
        sHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Habilidad agregada"),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id")int id, @RequestBody DtoHabilidades dtohabi ){
        //Validar si existe el ID
        if (!sHabilidades.existById(id))
            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.NOT_FOUND);
        //Compara nombre de habilidad
        if (sHabilidades.existByNombreH(dtohabi.getNombreH())&& sHabilidades.getByNombreH(dtohabi.getNombreH()).get().getId()!=id) 
            return new ResponseEntity(new Mensaje("Esa Habilidad No Existe"),HttpStatus.NOT_FOUND);
        // No puede estar vacio
        if (StringUtils.isBlank(dtohabi.getNombreH()))
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
        
        Habilidades habilidades=sHabilidades.getOne(id).get();
        habilidades.setNombreH(dtohabi.getNombreH());
        habilidades.setValorH((dtohabi.getValorH()));
        sHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        //Validar si existe el ID
        if (!sHabilidades.existById(id))
            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.BAD_REQUEST);       
       sHabilidades.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"),HttpStatus.OK);
    }
    
}
