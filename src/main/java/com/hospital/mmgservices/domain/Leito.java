package com.hospital.mmgservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hospital.mmgservices.domain.enums.StatusQuartoEnum;

@Entity
public class Leito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nomequarto", length = 50, nullable = true)
	private String nomequarto;

	@ManyToOne
	@JoinColumn(name = "quarto_id")
	private Quarto quarto;

	private Integer statusquartoenum;
	
	public Leito() {

	}

	public Leito(Integer id, String nomequarto, Quarto quarto, StatusQuartoEnum statusquartoenum) {
		super();
		this.id = id;
		this.nomequarto = nomequarto;
		this.quarto = quarto;
		this.statusquartoenum = (statusquartoenum == null) ? null : statusquartoenum.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomequarto() {
		return nomequarto;
	}

	public void setNomequarto(String nomequarto) {
		this.nomequarto = nomequarto;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public StatusQuartoEnum getTipo() {
		return StatusQuartoEnum.toEnum(statusquartoenum);
	}
	
	public Integer getStatusquartoenum() {
		return statusquartoenum;
	}

	public void setStatusquartoenum(Integer statusquartoenum) {
		this.statusquartoenum = statusquartoenum;
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
		Leito other = (Leito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
