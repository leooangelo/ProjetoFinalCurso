package com.mballem.curso.security.service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mballem.curso.security.domain.Contato;
import com.mballem.curso.security.repository.ContatoRepository;

/**
 * 
 * @author leonardoangelo
 *
 */
@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	
	/**
	 * Metodo que salva um novo contato
	 * 
	 * @param usuario
	 * @throws MessagingException 
	 */
	
	@Transactional
	public void salvarContato(Contato contato){
		contatoRepository.save(contato);
	}



}
