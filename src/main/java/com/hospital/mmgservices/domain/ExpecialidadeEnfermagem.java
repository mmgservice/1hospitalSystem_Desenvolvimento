package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ExpecialidadeEnfermagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "expecialidade", length = 50, nullable = true)
	private String expecialidade;

	@OneToMany(mappedBy = "expecialidadeenfermagem")
	private List<Enfermagem> enfermagem;

	public ExpecialidadeEnfermagem() {

	}

	public ExpecialidadeEnfermagem(Integer id, String expecialidade, List<Enfermagem> enfermagem) {
		super();
		this.id = id;
		this.expecialidade = expecialidade;
		this.enfermagem = enfermagem;
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

	public List<Enfermagem> getEnfermagem() {
		return enfermagem;
	}

	public void setEnfermagem(List<Enfermagem> enfermagem) {
		this.enfermagem = enfermagem;
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
		ExpecialidadeEnfermagem other = (ExpecialidadeEnfermagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
