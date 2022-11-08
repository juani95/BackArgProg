/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backargprog.backend.Interface;

import com.backargprog.backend.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    public List<Persona> getPersona();

    public void savePersona(Persona persona) ;

    public void deletePersona(Long id) ;

    public Persona findPersona(Long id);
}
