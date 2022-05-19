/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pablo.Controlador;

import com.portfolio.pablo.Entidad.Persona;
import com.portfolio.pablo.Interface.IPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Notebook
 */
@RestController
public class PersonaControlador {

    @Autowired
    IPersonaServicio ipersonaservicio;

    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return ipersonaservicio.getPersona();
    }
    
    @PostMapping("personas/crear")
    public String crearPersona(@RequestBody Persona persona){
        ipersonaservicio.guardaPersona(persona);
        return "la persona fue creada corretamente";
    }
    
    @DeleteMapping("personas/borrar/{id}")
    public String borraPersona(@PathVariable Long id) {
        ipersonaservicio.borraPersona(id);
        return "la persona fue borrada corretamente";
    }
    @PutMapping("personas/editar/{id}")
    public Persona editaPersona(@PathVariable Long id,
        @RequestParam("nombre")String nuevoNombre,
        @RequestParam("apellido")String nuevoApellido,
        @RequestParam("img")String nuevoImg){
    Persona persona = ipersonaservicio.buscaPersona(id);
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);
    persona.setImg(nuevoImg);
    ipersonaservicio.guardaPersona(persona);
    return persona;
    
    }

    
    
    

}
