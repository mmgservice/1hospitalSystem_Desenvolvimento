package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.CategoriaExame;

public class CategoriaExameDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public CategoriaExameDTO() {

	}

	public CategoriaExameDTO(CategoriaExame categoriaExame) {
		this.id = categoriaExame.getId();
		this.nome = categoriaExame.getNome();
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
		return "CategoriaExameDTO [id=" + id + ", nome=" + nome + "]";
	}

}
