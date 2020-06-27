package com.hospital.mmgservices.domain.enums;

public enum StatusEvolMedEnum {
	
	DIA(1, "DIA"), 
	TARDE(2, "TARDE"), 
	NOITE(3, "NOITE");

	private int cod;
	private String descricao;
	
	
	private StatusEvolMedEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public static StatusEvolMedEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (StatusEvolMedEnum x : StatusEvolMedEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
