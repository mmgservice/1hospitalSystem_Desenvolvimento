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
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", length = 50, nullable = true )
	private String nome;
	
	@Column(name = "crm", length = 15, nullable = true)
	private String crm;
	
	@OneToOne
	@JoinColumn(name = "expecialidade_id")
	private ExpecialidadeMedico expecialidademedico;
}
