package com.mballem.curso.security.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
public class Paciente extends AbstractEntity {

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtNascimento;
	
	@CPF
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "telefone", nullable = false)
	private String telefone;
	
	@Column(name = "celular", nullable = false)
	private String celular;
	
	@Column(name = "cep", nullable = false)
	private String cep;
	
	@Column(name = "rua", nullable = false)
	private String rua;
	
	@Column(name = "numero", nullable = false)
	private String numero;
	
	@JsonIgnore
	@OneToMany(mappedBy = "paciente")
	private List<Agendamento> agendamentos;
	
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	/**
	@JsonIgnore
	@OneToMany(mappedBy = "id_prontuario")
	private Prontuario prontuarios;
	*/
	
	public Paciente(Usuario usuario) {
		this.usuario = usuario;
	}

}
