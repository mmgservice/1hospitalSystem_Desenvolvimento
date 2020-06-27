package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Telefone;

public class TelefoneDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String telefone1;
	private String telefone2;
	private String telefone3;

	public TelefoneDTO() {

	}

	public TelefoneDTO(Telefone obj) {
		this.id = obj.getId();
		this.telefone1 = obj.getTelefone1();
		this.telefone2 = obj.getTelefone2();
		this.telefone3 = obj.getTelefone3();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	@Override
	public String toString() {
		return "TelefoneDTO [id=" + id + ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", telefone3="
				+ telefone3 + "]";
	}

}
