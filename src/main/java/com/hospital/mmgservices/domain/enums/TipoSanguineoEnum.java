package com.hospital.mmgservices.domain.enums;

public enum TipoSanguineoEnum {
	
    AP(1, "A+"),
	AN(2, "A-"),
	BP(3, "B+"),
	BN(4, "B-"),
	ABP(5, "AB+"),
	ABN(6, "AB-"),
	OP(7, "O+"),
	ON(8, "O-");
	
	private int cod;
	private String descricao;
	
	private TipoSanguineoEnum(int cod, String descricao) {
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
		
	public static TipoSanguineoEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (TipoSanguineoEnum x : TipoSanguineoEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

