/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Controller;

import com.portfolio.pabloh.Dto.DtoProyecto;
import com.portfolio.pabloh.Entity.Proyecto;
import com.portfolio.pabloh.Security.Controller.Mensaje;
import com.portfolio.pabloh.Service.SProyecto;
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
@RequestMapping("proye")
@CrossOrigin(origins = {"https://frontendpablo.web.app","http://localhost:4200"})
public class CProyecto {
    @Autowired
    SProyecto sproyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>>list(){
        List<Proyecto> list=sproyecto.list();
        return new ResponseEntity(list,HttpStatus.OK);        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sproyecto.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sproyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoProyecto dtoproye){
        if (StringUtils.isBlank(dtoproye.getNombrePr()))
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
        if (sproyecto.existByNombrePr(dtoproye.getNombrePr()))
            return new ResponseEntity(new Mensaje("Ese Proyecto Existe"),HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto=new Proyecto (dtoproye.getNombrePr(),dtoproye.getDescripcionPr(),dtoproye.getFotoPr());
        sproyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado"),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id")int id, @RequestBody DtoProyecto dtoproye ){
        //Validar si existe el ID
        if (!sproyecto.existById(id))
            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.NOT_FOUND);
        //Compara nombre de educacion
        if (sproyecto.existByNombrePr(dtoproye.getNombrePr())&& sproyecto.getByNombrePr(dtoproye.getNombrePr()).get().getId()!=id) 
            return new ResponseEntity(new Mensaje("Ese Proyecto No Existe"),HttpStatus.NOT_FOUND);
        // No puede estar vacio
        if (StringUtils.isBlank(dtoproye.getNombrePr()))
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
        
        Proyecto proyecto=sproyecto.getOne(id).get();
        proyecto.setNombrePr(dtoproye.getNombrePr());
        proyecto.setDescripcionPr((dtoproye.getDescripcionPr()));
        proyecto.setFotoPr((dtoproye.getFotoPr()));
        sproyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        //Validar si existe el ID
        if (!sproyecto.existById(id))
            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.BAD_REQUEST);       
       sproyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"),HttpStatus.OK);
    }
}
