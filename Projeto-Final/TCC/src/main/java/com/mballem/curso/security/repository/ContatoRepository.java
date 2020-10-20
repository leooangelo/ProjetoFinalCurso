package com.mballem.curso.security.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mballem.curso.security.domain.Contato;
/**
 * 
 * @author leonardoangelo
 *
 */
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	

} 
