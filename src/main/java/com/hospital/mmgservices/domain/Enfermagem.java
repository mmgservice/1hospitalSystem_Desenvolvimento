package com.hospital.mmgservices.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Enfermagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", length = 100, nullable = true)
	private String nome;

	@Column(name = "coren", length = 100, nullable = true)
	private String coren;

	@ManyToOne
	@JoinColumn(name = "expecialidade_id")
	private ExpecialidadeEnfermagem expecialidadeenfermagem;

	public Enfermagem() {

	}

	public Enfermagem(Integer id, String nome, String coren, ExpecialidadeEnfermagem expecialidadeenfermagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.coren = coren;
		this.expecialidadeenfermagem = expecialidadeenfermagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCoren() {
		return coren;
	}

	public void setCoren(String coren) {
		this.coren = coren;
	}

	public ExpecialidadeEnfermagem getExpecialidadeenfermagem() {
		return expecialidadeenfermagem;
	}

	public void setExpecialidadeenfermagem(ExpecialidadeEnfermagem expecialidadeenfermagem) {
		this.expecialidadeenfermagem = expecialidadeenfermagem;
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
		Enfermagem other = (Enfermagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
