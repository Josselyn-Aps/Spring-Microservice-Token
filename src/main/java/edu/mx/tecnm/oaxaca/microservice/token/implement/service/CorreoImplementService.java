/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.tecnm.oaxaca.microservice.token.implement.service;

import edu.mx.tecnm.oaxaca.microservice.token.model.CorreoModel;
import edu.mx.tecnm.oaxaca.microservice.token.service.CorreoService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author JOSELYNE
 */
@Service
public class CorreoImplementService implements CorreoService {

    @Override
    public void enviarCorreo(CorreoModel correoModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getCorreos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CorreoModel getCorreo(int idCorreo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCorreo(CorreoModel correoModel, int idCorreo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCorreo(int idCorreo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CorreoModel getCorreofindByIdCorreo(int idCorreo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
