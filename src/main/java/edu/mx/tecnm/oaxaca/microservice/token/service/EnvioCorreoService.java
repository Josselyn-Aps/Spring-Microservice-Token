/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.tecnm.oaxaca.microservice.token.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author JOSELYNE
 */
@Service("envioCorreoService")
public class EnvioCorreoService {
    private JavaMailSender javaMailSender;

  @Autowired
  public EnvioCorreoService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }
  
  @Async
  public void sendEmail(SimpleMailMessage email) {
	  javaMailSender.send(email);
  }
}
