package com.mballem.curso.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author leonardoangelo
 *
 *	Classe para criação de um paciente, esta classe utiliza lombok getters,setters e construtor padrão. 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "contatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato extends AbstractEntity {

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;

	@Email(message = "Email inválido")
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "telefone", unique = true, nullable = false)
	private String telefone;
	
	@Column(name = "mensagem", unique = true, nullable = false)
	private String mensagem;

}
