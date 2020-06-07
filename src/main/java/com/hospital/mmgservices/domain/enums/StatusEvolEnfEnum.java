package com.hospital.mmgservices.domain.enums;

public enum StatusEvolEnfEnum {

	  DIA(1,"DIA"),
	  TARDE(2,"TARDE"),
	  NOITE(3,"NOITE");
	
	private int cod;
	private String descricao;

	private StatusEvolEnfEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusEvolEnfEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (StatusEvolEnfEnum x : StatusEvolEnfEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}