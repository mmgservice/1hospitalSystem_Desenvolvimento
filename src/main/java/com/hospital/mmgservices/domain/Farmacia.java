package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Farmacia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "datasistema", nullable = true)
	private Date datasistema;
	
	@Column(name = "dosagem", length = 10, nullable = true)
	private String dosagem;
	
	@Column(name = "quantidade", nullable = true)
	private Double quantidade;
	
	@Column(name = "quantidadetotal", nullable = true)
	private Double quantidadetotal;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "datavencimento", nullable = true)
	private Date datavencimento;
	
	@Column(name = "valor", nullable = true)
	private BigDecimal valor;
	
	@Column(name = "valortotal", nullable = true)
	private BigDecimal valortotal;
	
	@ManyToOne
	@JoinColumn(name = "medicamento_id")
	private Medicamento medicamento;
	
	public Farmacia() {
		
	}

	public Farmacia(Integer id, Date datasistema, String dosagem, Double quantidade, Double quantidadetotal,
			Date datavencimento, BigDecimal valor, BigDecimal valortotal, Medicamento medicamento) {
		super();
		this.id = id;
		this.datasistema = datasistema;
		this.dosagem = dosagem;
		this.quantidade = quantidade;
		this.quantidadetotal = quantidadetotal;
		this.datavencimento = datavencimento;
		this.valor = valor;
		this.valortotal = valortotal;
		this.medicamento = medicamento;
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

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Farmacia other = (Farmacia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
