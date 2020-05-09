package com.hospital.mmgservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Enfermagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", length = 15, nullable = true)
	private String nome;

	@Column(name = "coren", length = 15, nullable = true)
	private String coren;

	@OneToOne
	@JoinColumn(name = "expecialidade_id")
	private ExpecialidadeEnfermagem expecialidadeenfermagem;




   }
