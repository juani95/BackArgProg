/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backargprog.backend.Controller;

import com.backargprog.backend.Entity.Persona;
import com.backargprog.backend.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontargprog-b4035.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService ;

   @GetMapping("/personas/traer")
   public List<Persona> getPersona() {
       return ipersonaService.getPersona() ;
}

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
       ipersonaService.savePersona(persona);
       return "La persona se agregó correctamente" ;
        }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
       ipersonaService.deletePersona(id);
       return "La persona se eliminó" ;
            }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
public Persona editPersona(@PathVariable Long id,
                            @RequestParam("nombre") String nuevoNombre,
                            @RequestParam("apellido") String nuevoApellido){
    Persona persona = ipersonaService.findPersona(id) ;

    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);

    ipersonaService.savePersona(persona);
    return persona  ;         
        }

@GetMapping("/personas/traer/perfil/{id}")
  public Persona findPersona(@PathVariable Long id){
        return ipersonaService.findPersona(id) ;
        }

}
