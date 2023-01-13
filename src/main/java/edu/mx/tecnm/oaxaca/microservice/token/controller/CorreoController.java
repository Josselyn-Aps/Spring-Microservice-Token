/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.tecnm.oaxaca.microservice.token.controller;

import edu.mx.tecnm.oaxaca.microservice.token.model.CorreoModel;
import edu.mx.tecnm.oaxaca.microservice.token.model.TokenConfirmacion;
import edu.mx.tecnm.oaxaca.microservice.token.model.Usuario;
import edu.mx.tecnm.oaxaca.microservice.token.repository.CorreoRepository;
import edu.mx.tecnm.oaxaca.microservice.token.repository.TokenConfirmacionRepository;
import edu.mx.tecnm.oaxaca.microservice.token.repository.UsuarioRepository;
import edu.mx.tecnm.oaxaca.microservice.token.service.EnvioCorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JOSELYNE
 */
@RestController
@RequestMapping("/confirmacion/correo")
@CrossOrigin(origins = "*")
public class CorreoController {
    @Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TokenConfirmacionRepository confirmationTokenRepository;
	
	@Autowired
	private EnvioCorreoService envioCorreoService;
        
        @GetMapping("/registro")
	public ModelAndView displayRegistration(ModelAndView modelAndView, Usuario usuario)
	{
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("registrado");
		return modelAndView;
	}
        
        @PostMapping("/registro")
	public ModelAndView registrarUsuario(ModelAndView modelAndView, Usuario usuario, CorreoModel correo)
	{
		
		Usuario existingUser = usuarioRepository.findByEmailIdIgnoreCase(usuario.getCorreo());
		if(existingUser != null)
		{
			modelAndView.addObject("message","This email already exists!");
			modelAndView.setViewName("error");
		}
		else 
		{
			usuarioRepository.save(usuario);
			
			TokenConfirmacion confirmationToken = new TokenConfirmacion(correo);
			
			confirmationTokenRepository.save(confirmationToken);
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(usuario.getCorreo());
			mailMessage.setSubject("Complete Registration!");
			mailMessage.setFrom("votacionnl23@gmail.com");
			mailMessage.setText("Para confirmar tu cuenta, por favor haz click aquí: "
			+"http://localhost:8082/confirm-account?token="+confirmationToken.getConfirmationToken());
			
			envioCorreoService.sendEmail(mailMessage);
			
			modelAndView.addObject("emailId", usuario.getCorreo());
			
			modelAndView.setViewName("successfulRegisteration");
		}
		
		return modelAndView;
	}
        
        @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken
        ,@RequestParam("correo") String Correo)
	{
		TokenConfirmacion token = confirmationTokenRepository.findByTokenConfirmacion(confirmationToken);
		
		if(token != null)
		{
			Usuario usuario = usuarioRepository.findByEmailIdIgnoreCase(token.getUser().getDestinatario());
			//correo.setEnabled(true);
			usuarioRepository.save(usuario);
			modelAndView.setViewName("CuentaVerificada");
		}
		else
		{
			modelAndView.addObject("message","The link is invalid or broken!");
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}
}
