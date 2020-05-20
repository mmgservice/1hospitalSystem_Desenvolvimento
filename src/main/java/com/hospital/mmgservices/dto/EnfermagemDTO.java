package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Enfermagem;

public class EnfermagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String coren;
	private Integer expecialidadeId;

	public EnfermagemDTO() {

	}

	public EnfermagemDTO(Enfermagem obj) {
		id = obj.getId();
		nome = obj.getNome();
		coren = obj.getCoren();
		expecialidadeId = obj.getExpecialidadeenfermagem().getId();
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

	public Integer getExpecialidadeId() {
		return expecialidadeId;
	}

	public void setExpecialidadeId(Integer expecialidadeId) {
		this.expecialidadeId = expecialidadeId;
	}

	@Override
	public String toString() {
		return "EnfermeiroDTO [id=" + id + ", nome=" + nome + ", crm=" + coren + ", expecialidadeId=" + expecialidadeId + "]";
	}

}
