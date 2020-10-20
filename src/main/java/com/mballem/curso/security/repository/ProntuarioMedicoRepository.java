package com.mballem.curso.security.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mballem.curso.security.domain.Prontuario;

public interface ProntuarioMedicoRepository extends JpaRepository<Prontuario, Long> {

	
	@Query("select e from Especialidade e where e.titulo like :search%")
	Page<Prontuario> findAllByTitulo(String search, Pageable pageable);
	
	@Query("select e.titulo from Especialidade e where e.titulo like :termo%")
	List<String> findEspecialidadesByTermo(String termo);

	@Query("select e from Especialidade e where e.titulo IN :titulos")
	Set<Prontuario> findByTitulos(String[] titulos);
	
	@Query("select count(e) from Especialidade e")
	Long findByQuantidade();
	
}
