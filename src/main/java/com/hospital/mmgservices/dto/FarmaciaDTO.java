package com.hospital.mmgservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import com.hospital.mmgservices.domain.Farmacia;

public class FarmaciaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date datasistema;
	private String dosagem;
	private Double quantidade;
	private Double quantidadetotal;
	private Date datavencimento;
	private BigDecimal valor;
	private BigDecimal valortotal;
	private Integer medicamentoId;
	
	public FarmaciaDTO(){
		
	}
	public FarmaciaDTO(Farmacia obj) {
		this.id = obj.getId();
		this.datasistema = obj.getDatasistema();
		this.dosagem = obj.getDosagem();
		this.quantidade = obj.getQuantidade();
		this.quantidadetotal = obj.getQuantidadetotal();
		this.datavencimento = obj.getDatavencimento();
		this.valor = obj.getValor();
		this.valortotal = obj.getValortotal();
		this.medicamentoId = obj.getMedicamento().getId();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDatasistema() {
		return datasistema;
	}
	public void setDatasistema(Date datasistema) {
		this.datasistema = datasistema;
	}
	public String getDosagem() {
		return dosagem;
	}
	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public Double getQuantidadetotal() {
		return quantidadetotal;
	}
	public void setQuantidadetotal(Double quantidadetotal) {
		this.quantidadetotal = quantidadetotal;
	}
	public Date getDatavencimento() {
		return datavencimento;
	}
	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getValortotal() {
		return valortotal;
	}
	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}
	public Integer getMedicamentoId() {
		return medicamentoId;
	}
	public void setMedicamentoId(Integer medicamentoId) {
		this.medicamentoId = medicamentoId;
	}
	@Override
	public String toString() {
		return "FarmaciaDTO [id=" + id + ", datasistema=" + datasistema + ", dosagem=" + dosagem + ", quantidade="
				+ quantidade + ", quantidadetotal=" + quantidadetotal + ", datavencimento=" + datavencimento
				+ ", valor=" + valor + ", valortotal=" + valortotal + ", medicamentoId=" + medicamentoId + "]";
	}
	
	
}
