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
	
	
	
	public Prescricao() {
		
	}

	public Prescricao(Integer id, Date datasistema, String via, String freq, Time horario1, Time horario2,
			Time horario3, Time horario4, Time horario5, Time horario6, Medico medico, Enfermagem enfermagem) {
		super();
		this.id = id;
		this.datasistema = datasistema;
		this.via = via;
		this.freq = freq;
		this.horario1 = horario1;
		this.horario2 = horario2;
		this.horario3 = horario3;
		this.horario4 = horario4;
		this.horario5 = horario5;
		this.horario6 = horario6;
		this.medico = medico;
		this.enfermagem = enfermagem;
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

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getFreq() {
		return freq;
	}

	public void setFreq(String freq) {
		this.freq = freq;
	}

	public Time getHorario1() {
		return horario1;
	}

	public void setHorario1(Time horario1) {
		this.horario1 = horario1;
	}

	public Time getHorario2() {
		return horario2;
	}

	public void setHorario2(Time horario2) {
		this.horario2 = horario2;
	}

	public Time getHorario3() {
		return horario3;
	}

	public void setHorario3(Time horario3) {
		this.horario3 = horario3;
	}

	public Time getHorario4() {
		return horario4;
	}

	public void setHorario4(Time horario4) {
		this.horario4 = horario4;
	}

	public Time getHorario5() {
		return horario5;
	}

	public void setHorario5(Time horario5) {
		this.horario5 = horario5;
	}

	public Time getHorario6() {
		return horario6;
	}

	public void setHorario6(Time horario6) {
		this.horario6 = horario6;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
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
		Prescricao other = (Prescricao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
