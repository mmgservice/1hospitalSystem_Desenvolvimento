package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Medicamento;

public class MedicamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private CategoriaMedicamentoDTO categoriamedicamento;
	
	public MedicamentoDTO() {
		
	}
	public MedicamentoDTO(Medicamento obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.categoriamedicamento = new CategoriaMedicamentoDTO(obj.getCategoriamedicamento());
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
	public CategoriaMedicamentoDTO getCategoriamedicamento() {
		return categoriamedicamento;
	}
	public void setCategoriamedicamento(CategoriaMedicamentoDTO categoriamedicamento) {
		this.categoriamedicamento = categoriamedicamento;
	}
	@Override
	public String toString() {
		return "MedicamentoDTO [id=" + id + ", nome=" + nome + ", categoriamedicamento=" + categoriamedicamento + "]";
	}

	
	
}
