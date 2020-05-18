package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Leito;

public class LeitoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomequarto;
	private Integer statusquartoenum;
	private Integer quartoId;

	public LeitoDTO() {

	}
	
	public LeitoDTO(Leito obj) {
		this.id = obj.getId();
		this.nomequarto = obj.getNomequarto();
		this.statusquartoenum = obj.getStatusquartoenum();
		this.quartoId = obj.getQuarto().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomequarto() {
		return nomequarto;
	}

	public void setNomequarto(String nomequarto) {
		this.nomequarto = nomequarto;
	}

	public Integer getQuartoId() {
		return quartoId;
	}

	public void setQuartoId(Integer quartoId) {
		this.quartoId = quartoId;
	}
	

	public Integer getStatusquartoenum() {
		return statusquartoenum;
	}

	public void setStatusquartoenum(Integer statusquartoenum) {
		this.statusquartoenum = statusquartoenum;
	}

	@Override
	public String toString() {
		return "LeitoDTO [id=" + id + ", nomequarto=" + nomequarto + ", quartoId=" + quartoId + "]";
	}
	
	

}
