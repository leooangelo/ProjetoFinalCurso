package com.mballem.curso.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mballem.curso.security.domain.Prontuario;

public interface ProntuarioMedicoRepository extends JpaRepository<Prontuario, Long> {

	
	@Query()
	Prontuario findProntuarioById(Long id);
	

}
