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
public class EvolucaoMedico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "evolucaomed", nullable = true)
	private String evolucaomed;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dataevolucao", nullable = true)
	private Date dataevolucao;
	
	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	//@OneToMany(mappedBy = "evolucaoMedico")
	//private List<Prontuario> prontuario = new ArrayList<>();
}
