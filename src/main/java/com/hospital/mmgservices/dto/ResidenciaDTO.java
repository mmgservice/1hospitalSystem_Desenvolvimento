package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Residencia;

public class ResidenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String tipoResidencia;

	public ResidenciaDTO() {

	}

	public ResidenciaDTO(Residencia obj) {
		id = obj.getId();
		tipoResidencia = obj.getTiporesidencia();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(String tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}

}
