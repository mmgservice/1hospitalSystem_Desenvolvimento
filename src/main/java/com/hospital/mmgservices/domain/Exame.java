package com.hospital.mmgservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hospital.mmgservices.domain.enums.StatusExameEnum;

@Entity
public class Exame implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "datasistema", nullable = true)
	private String datasistema;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "dataexame", nullable = true)
	private String dataexame;

	private String horario;

	@ManyToOne
	@JoinColumn(name = "nomeexame_id")
	private NomeExame nomeexame;

	private Integer StatusExameEnum;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	// @OneToMany(mappedBy = "exame")
	// private List<Prontuario> prontuario = new ArrayList<>();

	public Exame() {

	}

	

	public Exame(Integer id, String datasistema, String dataexame, String horario, NomeExame nomeexame,
			StatusExameEnum statusExameEnum, Paciente paciente, Medico medico) {
		super();
		this.id = id;
		this.datasistema = datasistema;
		this.dataexame = dataexame;
		this.horario = horario;
		this.nomeexame = nomeexame;
		StatusExameEnum = (statusExameEnum == null) ? null : statusExameEnum.getCod();
		this.paciente = paciente;
		this.medico = medico;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDatasistema() {
		return datasistema;
	}

	public void setDatasistema(String datasistema) {
		this.datasistema = datasistema;
	}

	public String getDataexame() {
		return dataexame;
	}

	public void setDataexame(String dataexame) {
		this.dataexame = dataexame;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public NomeExame getNomeexame() {
		return nomeexame;
	}

	public void setNomeexame(NomeExame nomeexame) {
		this.nomeexame = nomeexame;
	}

	public Integer getStatusExameEnum() {
		return StatusExameEnum;
	}

	public void setStatusExameEnum(Integer statusExameEnum) {
		StatusExameEnum = statusExameEnum;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
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
		Exame other = (Exame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
