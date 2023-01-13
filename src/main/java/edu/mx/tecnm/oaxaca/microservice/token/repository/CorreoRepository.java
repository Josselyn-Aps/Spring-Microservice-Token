/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.tecnm.oaxaca.microservice.token.repository;

import edu.mx.tecnm.oaxaca.microservice.token.model.CorreoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JOSELYNE
 */
@Repository
public interface CorreoRepository extends JpaRepository<CorreoModel, Integer>{

    public CorreoModel findByIdCorreo(int correo);
}
