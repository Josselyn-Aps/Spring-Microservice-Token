/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.tecnm.oaxaca.microservice.token.repository;

import edu.mx.tecnm.oaxaca.microservice.token.model.TokenConfirmacion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JOSELYNE
 */
public interface TokenConfirmacionRepository extends CrudRepository<TokenConfirmacion, String>{
    TokenConfirmacion findByTokenConfirmacion(String tokenConfirmacion);
}
