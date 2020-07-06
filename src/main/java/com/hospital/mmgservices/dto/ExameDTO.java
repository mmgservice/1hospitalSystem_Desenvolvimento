package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Exame;

public class ExameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String datasistema;
	private String dataexame;
	private String horario;
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
		this.horario = obj.getHorario();
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

	public String getDatasistema() {
		return datasistema;
	}

	public void setDatasistema(String datasistema) {
		this.datasistema = datasistema;
	}

	public String getDataexame() {
		return dataexame;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setDataexame(String dataexame) {
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
		return "ExameDTO [id=" + id + ", datasistema=" + datasistema + ", dataexame=" + dataexame + ", horario="
				+ horario + ", nomeexame=" + nomeexame + ", statusExameId=" + statusExameId + ", paciente=" + paciente
				+ ", medico=" + medico + "]";
	}

}
