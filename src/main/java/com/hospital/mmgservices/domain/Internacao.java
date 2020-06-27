package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hospital.mmgservices.domain.enums.StatusInternacaoEnum;

@Entity
public class Internacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInternacao;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "quarto_id")
	private Quarto quarto;
	
	@OneToMany(mappedBy = "internacao")
	private List<Prontuario> prontuario = new ArrayList<>();

	private Integer StatusInternacaoEnum;

	public Internacao() {

	}

	public Internacao(Integer id, Date dataInternacao, Paciente paciente, Quarto quarto,
			StatusInternacaoEnum statusInternacaoEnum) {
		super();
		this.id = id;
		this.dataInternacao = dataInternacao;
		this.paciente = paciente;
		this.quarto = quarto;
		StatusInternacaoEnum = (statusInternacaoEnum == null) ? null : statusInternacaoEnum.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInternacao() {
		return dataInternacao;
	}

	public void setDataInternacao(Date dataInternacao) {
		this.dataInternacao = dataInternacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Integer getStatusInternacaoEnum() {
		return StatusInternacaoEnum;
	}

	public void setStatusInternacaoEnum(Integer statusInternacaoEnum) {
		StatusInternacaoEnum = statusInternacaoEnum;
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
		Internacao other = (Internacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Internacao [id=" + id + ", dataInternacao=" + dataInternacao + ", paciente=" + paciente + ", quarto="
				+ quarto + ", StatusInternacaoEnum=" + StatusInternacaoEnum + "]";
	}

}
