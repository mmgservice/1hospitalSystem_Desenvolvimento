package com.hospital.mmgservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ExpecialidadeMedico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="expecialidade", length = 50, nullable = true)
	private String expecialidade;
	
	@OneToOne(mappedBy = "expecialidademedico")
	private Medico medico;
	
	public ExpecialidadeMedico() {
		
	}

	public ExpecialidadeMedico(Integer id, String expecialidade, Medico medico) {
		super();
		this.id = id;
		this.expecialidade = expecialidade;
		this.medico = medico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExpecialidade() {
		return expecialidade;
	}

	public void setExpecialidade(String expecialidade) {
		this.expecialidade = expecialidade;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpecialidadeMedico other = (ExpecialidadeMedico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
