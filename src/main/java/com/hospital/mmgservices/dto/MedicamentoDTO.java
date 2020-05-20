package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Medicamento;

public class MedicamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer categoriaId;
	
	public MedicamentoDTO() {
		
	}
	public MedicamentoDTO(Medicamento obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.categoriaId = obj.getCategoriamedicamento().getId();
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
	public Integer getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	@Override
	public String toString() {
		return "MedicamentoDTO [id=" + id + ", nome=" + nome + ", categoriaId=" + categoriaId + "]";
	}
	
	
}
