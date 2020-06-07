package com.hospital.mmgservices.domain;

import java.io.Serializable;
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
public class EvolucaoEnfermagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "evolucaoenf", nullable = true)
	private String evolucaoenf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dataevolucao", nullable = true)
	private Date dataevolucao;

	@ManyToOne
	@JoinColumn(name = "enfermagem_id")
	private Enfermagem enfermagem;

	public EvolucaoEnfermagem() {

	}

	public EvolucaoEnfermagem(Integer id, String evolucaoenf, Date dataevolucao, Enfermagem enfermagem) {
		super();
		this.id = id;
		this.evolucaoenf = evolucaoenf;
		this.dataevolucao = dataevolucao;
		this.enfermagem = enfermagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEvolucaoenf() {
		return evolucaoenf;
	}

	public void setEvolucaoenf(String evolucaoenf) {
		this.evolucaoenf = evolucaoenf;
	}

	public Date getDataevolucao() {
		return dataevolucao;
	}

	public void setDataevolucao(Date dataevolucao) {
		this.dataevolucao = dataevolucao;
	}

	public Enfermagem getEnfermagem() {
		return enfermagem;
	}

	public void setEnfermagem(Enfermagem enfermagem) {
		this.enfermagem = enfermagem;
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
		EvolucaoEnfermagem other = (EvolucaoEnfermagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
