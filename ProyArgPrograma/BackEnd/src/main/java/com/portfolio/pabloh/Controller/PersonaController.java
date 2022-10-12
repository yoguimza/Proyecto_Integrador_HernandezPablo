/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pabloh.Controller;


import com.portfolio.pabloh.Dto.DtoPersona;
import com.portfolio.pabloh.Entity.Persona;
import com.portfolio.pabloh.Security.Controller.Mensaje;
import com.portfolio.pabloh.Service.ImplPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Notebook
 */
@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://frontendpablo.web.app","http://localhost:4200"})
//@CrossOrigin(origins = "https://frontendpablo.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
   @Autowired 
   ImplPersonaService spersona;
   
   @GetMapping("/lista")
    public ResponseEntity<List<Persona>>list(){
        List<Persona> list=spersona.list();
        return new ResponseEntity(list,HttpStatus.OK);        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!spersona.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = spersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
//    @PostMapping("/create")
//    public ResponseEntity<?>create(@RequestBody DtoPersona dtoperso){
//        if (StringUtils.isBlank(dtoperso.getNombre()))
//            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
//        if (spersona.existByNombreP(dtoperso.getNombre()))
//            return new ResponseEntity(new Mensaje("Esa Persona Existe"),HttpStatus.BAD_REQUEST);
//        
//        Persona persona=new Persona(dtoperso.getNombre(),dtoperso.getDescripcion());
//        spersona.save(persona);
//        return new ResponseEntity(new Mensaje("Persona agregada"),HttpStatus.OK);
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id")int id, @RequestBody DtoPersona dtoperso ){
        //Validar si existe el ID
        if (!spersona.existById(id))
            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.BAD_REQUEST);
        //Compara nombre de personas
        if (spersona.existByNombre(dtoperso.getNombre())&& spersona.getByNombre(dtoperso.getNombre()).get().getId()!=id) 
            return new ResponseEntity(new Mensaje("Esa Persona No Existe"),HttpStatus.BAD_REQUEST);
        // No puede estar vacio
        if (StringUtils.isBlank(dtoperso.getNombre()))
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"),HttpStatus.BAD_REQUEST );
        
        Persona persona = spersona.getOne(id).get();
        persona.setNombre(dtoperso.getNombre());
        persona.setApellido(dtoperso.getApellido());
        persona.setImg(dtoperso.getImg());
        persona.setDescripcion((dtoperso.getDescripcion()));
        spersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"),HttpStatus.OK);
    }
    
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?>delete(@PathVariable("id")int id){
//        //Validar si existe el ID
//        if (!spersona.existById(id))
//            return new ResponseEntity(new Mensaje("El ID No Existe"),HttpStatus.BAD_REQUEST);       
//       spersona.delete(id);
//        return new ResponseEntity(new Mensaje("Persona eliminada"),HttpStatus.OK);
//    }
   
   
   
   
   
   
   
   
   
//   
//   @GetMapping("/personas/traer")
//   public List <Persona> getPersona(){
//       return ipersonaservice.getPersona();
//   }
//   
//   @PreAuthorize("hasRole('ADMIN')")
//   @PostMapping("/personas/crear")
//   public String createPersona(@RequestBody Persona persona){
//       ipersonaservice.savePersona(persona);
//       return "La persona se creo correctamente";
//   }
//   
//   @PreAuthorize("hasRole('ADMIN')")
//   @DeleteMapping("/personas/borrar/{id}")
//   public String deletePersona(@PathVariable Long id){
//       ipersonaservice.deletePersona(id);
//       return "La persona se borro correctamente";
//   }
//   
//   @GetMapping("/personas/traer/perfil")
//   public Persona findPersona(){
//       return ipersonaservice.findPersona((long)1);       
//   }
//   
//   @PreAuthorize("hasRole('ADMIN')")
//   @PutMapping("/personas/editar/{id}")
//   public Persona editPersona(@PathVariable Long id,
//           @RequestParam("nombre")String nuevoNombre,
//           @RequestParam("apellido")String nuevoApellido,
//           @RequestParam("img")String nuevoImg){
//       Persona persona=ipersonaservice.findPersona(id);
//       persona.setNombre(nuevoNombre);
//       persona.setApellido(nuevoApellido);
//       persona.setImg(nuevoImg);
//       ipersonaservice.savePersona(persona);
//       return persona;              
//   } 
   
   
}
