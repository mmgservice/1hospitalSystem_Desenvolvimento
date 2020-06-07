package com.hospital.mmgservices.dto;

import java.io.Serializable;
import java.sql.Date;

import com.hospital.mmgservices.domain.EvolucaoEnfermagem;

public class EvolucaoEnfermagemDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String evolucaoenf;
	private Date dataevolucao;
	private Integer enfermagemId;
	
	public EvolucaoEnfermagemDTO() {
		
	}
	
	public EvolucaoEnfermagemDTO(EvolucaoEnfermagem obj) {
		this.id = obj.getId();
		this.evolucaoenf = obj.getEvolucaoenf();
		this.dataevolucao = obj.getDataevolucao();
		this.enfermagemId = obj.getEnfermagem().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEvolucaoenf() {
		return evolucaoenf;
	}

	public void setEvolucaoenf(String evolucaoenf) {
		this.evolucaoenf = evolucaoenf;
	}

	public Date getDataevolucao() {
		return dataevolucao;
	}

	public void setDataevolucao(Date dataevolucao) {
		this.dataevolucao = dataevolucao;
	}

	public Integer getEnfermagemId() {
		return enfermagemId;
	}

	public void setEnfermagemId(Integer enfermagemId) {
		this.enfermagemId = enfermagemId;
	}

	@Override
	public String toString() {
		return "EvolucaoEnfermagemDTO [id=" + id + ", evolucaoenf=" + evolucaoenf + ", dataevolucao=" + dataevolucao
				+ ", enfermagemId=" + enfermagemId + "]";
	}
	
	
}
