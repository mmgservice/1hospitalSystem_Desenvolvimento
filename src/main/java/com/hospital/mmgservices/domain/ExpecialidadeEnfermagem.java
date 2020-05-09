package com.hospital.mmgservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ExpecialidadeEnfermagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="expecialidade", length = 50, nullable = true)
	private String expecialidade;
	
	@OneToOne(mappedBy = "expecialidadeenfermagem")
	private Enfermagem enfermagem;
	
	public ExpecialidadeEnfermagem() {
		
	}

	
	
}
