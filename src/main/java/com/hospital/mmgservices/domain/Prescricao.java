package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Prescricao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "datasistema", nullable = true)
	private Date datasistema;
	
	@Column(name = "via", length = 150, nullable = true)
	private String via;
	
	@Column(name = "freq", length = 150, nullable = true)
	private String freq;
	
	@Column(name = "horario1", nullable = true)
	private Time horario1;
	
	@Column(name = "horario2", nullable = true)
	private Time horario2;
	
	@Column(name = "horario3", nullable = true)
	private Time horario3;
	
	@Column(name = "horario4",nullable = true)
	private Time horario4;
	
	@Column(name = "horario5", nullable = true)
	private Time horario5;
	
	@Column(name = "horario6", nullable = true)
	private Time horario6;
	
	@ManyToOne
	@JoinColumn(name = "medico_id")
	@JsonIgnore
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "enfer_id")
	@JsonIgnore
	private Enfermagem enfermagem;
	
}
