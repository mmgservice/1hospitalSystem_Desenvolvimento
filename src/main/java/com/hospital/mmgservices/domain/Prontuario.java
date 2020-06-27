package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Prontuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "datasistema", nullable = true)
	private Date dataProntuario;

	@ManyToOne
	@JoinColumn(name = "internacao_id")
	private Internacao internacao;

	@ManyToOne
	@JoinColumn(name = "exame_id")
	private Exame exame;

	@ManyToOne
	@JoinColumn(name = "prescricao_id")
	private Prescricao prescricao;

	@ManyToOne
	@JoinColumn(name = "evolucaoMed_id")
	private EvolucaoMedico evolucaoMedico;

	@ManyToOne
	@JoinColumn(name = "evolucaoEnf_id")
	private EvolucaoEnfermagem evolucaoEnfermagem;

}
