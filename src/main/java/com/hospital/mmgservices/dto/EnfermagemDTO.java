package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Enfermagem;

public class EnfermagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String coren;
	private ExpecialidadeEnfermagemDTO expecialidade;

	public EnfermagemDTO() {

	}

	public EnfermagemDTO(Enfermagem obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.coren = obj.getCoren();
		this.expecialidade = new ExpecialidadeEnfermagemDTO(obj.getExpecialidadeenfermagem());
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

	public ExpecialidadeEnfermagemDTO getExpecialidade() {
		return expecialidade;
	}

	public void setExpecialidade(ExpecialidadeEnfermagemDTO expecialidade) {
		this.expecialidade = expecialidade;
	}

	@Override
	public String toString() {
		return "EnfermagemDTO [id=" + id + ", nome=" + nome + ", coren=" + coren + ", expecialidade=" + expecialidade
				+ "]";
	}

}
