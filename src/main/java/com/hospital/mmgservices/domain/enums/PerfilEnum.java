package com.hospital.mmgservices.domain.enums;

public enum PerfilEnum {

	PROFISSIONALTI(1, "ROLE_ADMIN");

	private int cod;
	private String descricao;

	private PerfilEnum(int cod, String descricao) {
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

	public static PerfilEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (PerfilEnum x : PerfilEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
