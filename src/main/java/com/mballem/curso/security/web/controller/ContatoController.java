package com.mballem.curso.security.web.controller;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballem.curso.security.domain.Contato;
import com.mballem.curso.security.service.ContatoService;
import com.mballem.curso.security.service.EmailService;

/**
 * 
 * @author leonardoangelo
 *
 */
@Controller
@RequestMapping("contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private EmailService emailService;
	
	
	/**
	 * Metodo para mostrar formulario do contato
	 * @param especialidade
	 * @param redirect
	 * @return
	 */
	
	@GetMapping("/show")
	public String contato() {
		return "mostrar-contato";
	}
	
	
	/**
	 * Metodo para cadastrar um contato
	 * @param especialidade
	 * @param redirect
	 * @return
	 * @throws MessagingException 
	 */
	@PostMapping("/salvar")
	public String salvar(Contato contato, RedirectAttributes redirect, RedirectAttributes attr) throws MessagingException {
		try {
			contatoService.salvarContato(contato);
			
			emailService.enviarEmailContato(contato.getEmail(),contato);
			attr.addFlashAttribute("sucesso",
					"Sua consulta foi agendada com sucesso, verifique seu" + " email com os dados da consulta agendada.!");			
			return "redirect:/fale-conosco";

			
		} catch (Exception e) {
			attr.addFlashAttribute("falha",
					"Sua consulta foi agendada com sucesso, verifique seu" + " email com os dados da consulta agendada.!");			
			return "redirect:/home";
		}
		
		
	}
	
	
}