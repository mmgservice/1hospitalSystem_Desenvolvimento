package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Medico;

public class MedicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String crm;
	private ExpecialidadeMedicoDTO expecialidade;

	public MedicoDTO() {

	}

	public MedicoDTO(Medico obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.crm = obj.getCrm();
		this.expecialidade = new ExpecialidadeMedicoDTO(obj.getExpecialidademedico());
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public ExpecialidadeMedicoDTO getExpecialidade() {
		return expecialidade;
	}

	public void setExpecialidadeMedicoDTO(ExpecialidadeMedicoDTO expecialidade) {
		this.expecialidade = expecialidade;
	}

	@Override
	public String toString() {
		return "MedicoDTO [id=" + id + ", nome=" + nome + ", crm=" + crm + ", expecialidade=" + expecialidade + "]";
	}

}
