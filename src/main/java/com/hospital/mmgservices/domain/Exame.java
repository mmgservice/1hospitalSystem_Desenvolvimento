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
public class Exame implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "datasistema", nullable = true)
	private Date datasistema;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "dataexame", nullable = true)
	private Date dataexame;
	
	
	@ManyToOne
    @JoinColumn(name = "nomeexame_id")
	private NomeExame nomeexame;
	
	@ManyToOne
	@JoinColumn(name = "statusexame_id")
	private StatusExame statusexame;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn()
	private Medico medico;
	
	
	public Exame() {
		
	}


	public Exame(Integer id, Date datasistema, Date dataexame, NomeExame nomeexame, StatusExame statusexame,
			Paciente paciente) {
		super();
		this.id = id;
		this.datasistema = datasistema;
		this.dataexame = dataexame;
		this.nomeexame = nomeexame;
		this.statusexame = statusexame;
		this.paciente = paciente;
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


	public Date getDataexame() {
		return dataexame;
	}


	public void setDataexame(Date dataexame) {
		this.dataexame = dataexame;
	}


	public NomeExame getNomeexame() {
		return nomeexame;
	}


	public void setNomeexame(NomeExame nomeexame) {
		this.nomeexame = nomeexame;
	}


	public StatusExame getStatusexame() {
		return statusexame;
	}


	public void setStatusexame(StatusExame statusexame) {
		this.statusexame = statusexame;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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
