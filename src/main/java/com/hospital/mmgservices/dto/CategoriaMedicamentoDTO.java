package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.CategoriaMedicamento;

public class CategoriaMedicamentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	
	public CategoriaMedicamentoDTO() {
		
	}
	
	public CategoriaMedicamentoDTO(CategoriaMedicamento obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
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

	@Override
	public String toString() {
		return "CategoriaMedicamentoDTO [id=" + id + ", Nome=" + nome + "]";
	}

	
	
	
}
