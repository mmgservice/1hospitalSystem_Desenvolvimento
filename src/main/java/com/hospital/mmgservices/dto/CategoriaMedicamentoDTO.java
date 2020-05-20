package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.CategoriaMedicamento;

public class CategoriaMedicamentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String descricao;
	
	public CategoriaMedicamentoDTO() {
		
	}
	public CategoriaMedicamentoDTO(CategoriaMedicamento obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "CategoriaMedicamentoDTO [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
