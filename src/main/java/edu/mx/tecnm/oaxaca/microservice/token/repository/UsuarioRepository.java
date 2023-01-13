/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.tecnm.oaxaca.microservice.token.repository;

import edu.mx.tecnm.oaxaca.microservice.token.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JOSELYNE
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	Usuario findByEmailIdIgnoreCase(String emailId);
        //Usuario findByCurp(String curp);
}