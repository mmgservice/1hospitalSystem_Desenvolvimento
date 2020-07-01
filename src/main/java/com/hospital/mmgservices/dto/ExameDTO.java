package com.hospital.mmgservices.dto;

import java.io.Serializable;
import java.util.Date;

import com.hospital.mmgservices.domain.Exame;

public class ExameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date datasistema;
	private Date dataexame;
	private NomeExameDTO nomeexame;
	private Integer statusExameId;
	private PacienteDTO paciente;
	private MedicoDTO medico;

	public ExameDTO() {

	}

	public ExameDTO(Exame obj) {
		this.id = obj.getId(); 
		this.datasistema = obj.getDatasistema();
		this.dataexame = obj.getDataexame();
		this.nomeexame = new NomeExameDTO(obj.getNomeexame());
		this.statusExameId = obj.getStatusExameEnum();
		this.paciente = new PacienteDTO(obj.getPaciente());
		this.medico = new MedicoDTO(obj.getMedico());

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

	public NomeExameDTO getNomeexame() {
		return nomeexame;
	}

	public void setNomeexame(NomeExameDTO nomeexame) {
		this.nomeexame = nomeexame;
	}

	public Integer getStatusExameId() {
		return statusExameId;
	}

	public void setStatusExameId(Integer statusExameId) {
		this.statusExameId = statusExameId;
	}

	public PacienteDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
	}

	public MedicoDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoDTO medico) {
		this.medico = medico;
	}

	@Override
	public String toString() {
		return "ExameDTO [id=" + id + ", datasistema=" + datasistema + ", dataexame=" + dataexame + ", nomeexame="
				+ nomeexame + ", statusexame=" + statusExameId + ", paciente=" + paciente + ", medico=" + medico + "]";
	}

}
