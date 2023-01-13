/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.tecnm.oaxaca.microservice.token.service;

import edu.mx.tecnm.oaxaca.microservice.token.model.CorreoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author JOSELYNE
 */
@Service
public interface CorreoService {
    public void enviarCorreo(CorreoModel correoModel);
    public List getCorreos();
    public CorreoModel getCorreo(int idCorreo);
    public void updateCorreo(CorreoModel correoModel, int idCorreo);
    public void deleteCorreo(int idCorreo);
    public CorreoModel getCorreofindByIdCorreo(int idCorreo);
}
