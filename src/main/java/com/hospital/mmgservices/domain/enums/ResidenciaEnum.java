package com.hospital.mmgservices.domain.enums;

public enum ResidenciaEnum {

	CASA(1, "Casa"), 
	APARTAMENTO(2, "Apartamento"),
	ALUGADO(3, "Alugado");

	private int cod;
	private String descricao;

	private ResidenciaEnum(int cod, String descricao) {
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
	
	

	public static ResidenciaEnum toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (ResidenciaEnum x : ResidenciaEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);

	}
}
