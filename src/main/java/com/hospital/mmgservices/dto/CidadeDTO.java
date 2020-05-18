package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Integer estadoId;
	
	public CidadeDTO() {
		
	}

	public CidadeDTO(Cidade obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.estadoId = obj.getEstado().getId();
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

	public Integer getEstadoId() {
		return estadoId;
	}


	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	@Override
	public String toString() {
		return "CidadeDTO [id=" + id + ", nome=" + nome + ", estadoId=" + estadoId + "]";
	}

	
}
