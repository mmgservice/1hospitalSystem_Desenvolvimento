package com.hospital.mmgservices.domain.enums;

public enum StatusQuartoEnum {

	  DISPONIVEL(1,"DISPONIVEL"),
	  OCUPADO(2,"OCUPADO");
		
	private int cod;
	private String descricao;

	private StatusQuartoEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusQuartoEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (StatusQuartoEnum x : StatusQuartoEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}