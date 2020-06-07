package com.hospital.mmgservices.domain.enums;

public enum StatusExameEnum {

	MARCADO(1, "MARCADO"),
	NAOMARCADO(2, "NÃOMARCADO");

	private int cod;
	private String descricao;

	private StatusExameEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static StatusExameEnum toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (StatusExameEnum x : StatusExameEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);

	}
}
