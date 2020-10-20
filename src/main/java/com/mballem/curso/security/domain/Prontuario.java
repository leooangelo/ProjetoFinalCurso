package com.mballem.curso.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "prontuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prontuario extends AbstractEntity {
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "titulo")
	private String titulo;
}
