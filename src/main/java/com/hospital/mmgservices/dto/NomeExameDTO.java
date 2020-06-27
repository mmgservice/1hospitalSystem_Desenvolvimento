package com.hospital.mmgservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.hospital.mmgservices.domain.NomeExame;

public class NomeExameDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomedoexame;
	private BigDecimal valor;
	private CategoriaExameDTO categoriaExame;

	public NomeExameDTO() {

	}

	public NomeExameDTO(NomeExame obj) {
		this.id = obj.getId();
		this.nomedoexame = obj.getNomedoexame();
		this.valor = obj.getValor();
		this.categoriaExame = new CategoriaExameDTO(obj.getCategoriaexame());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomedoexame() {
		return nomedoexame;
	}

	public void setNomedoexame(String nomedoexame) {
		this.nomedoexame = nomedoexame;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public CategoriaExameDTO getCategoriaExame() {
		return categoriaExame;
	}

	public void setCategoriaExame(CategoriaExameDTO categoriaExame) {
		this.categoriaExame = categoriaExame;
	}
	
}
