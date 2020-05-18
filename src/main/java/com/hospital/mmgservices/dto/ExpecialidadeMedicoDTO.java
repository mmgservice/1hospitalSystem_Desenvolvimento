package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.ExpecialidadeMedico;

public class ExpecialidadeMedicoDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String expecialidade;
	
	public ExpecialidadeMedicoDTO() {
		
	}
	public ExpecialidadeMedicoDTO(ExpecialidadeMedico obj) {
		id = obj.getId();
		expecialidade = obj.getExpecialidade();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getExpecialidade() {
		return expecialidade;
	}
	public void setExpecialidade(String expecialidade) {
		this.expecialidade = expecialidade;
	}
	
	@Override
	public String toString() {
		return "ExpecialidadeMedicoDTO [id=" + id + ", expecialidade=" + expecialidade + "]";
	}
	
	
}
