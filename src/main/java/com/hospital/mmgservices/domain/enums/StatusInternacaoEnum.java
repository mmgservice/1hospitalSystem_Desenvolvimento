package com.hospital.mmgservices.domain.enums;

public enum StatusInternacaoEnum {

	INTERNADO(1, "INTERNADO"), 
	NAOINTERNADO(2, "NÃOINTERNADO");

	private int cod;
	private String descricao;

	private StatusInternacaoEnum(int cod, String descricao) {
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
	
	public static StatusInternacaoEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (StatusInternacaoEnum x : StatusInternacaoEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
