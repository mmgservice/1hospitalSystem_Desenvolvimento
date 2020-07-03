package com.hospital.mmgservices.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import com.hospital.mmgservices.domain.Prescricao;


public class PrescricaoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date datasistema;
	private String via;
	private String freq;
	private Time horario1;
	private Time horario2;
	private Time horario3;
	private Time horario4;
	private Time horario5;
	private Time horario6;
	private MedicoDTO medico;
	private EnfermagemDTO enfermagem;
	
	public PrescricaoDTO() {
		
	}
	
	public PrescricaoDTO(Prescricao obj) {
		this.id = obj.getId();
		this.datasistema = obj.getDatasistema();
		this.via = obj.getVia();
		this.freq = obj.getFreq();
		this.horario1 = obj.getHorario1();
		this.horario2 = obj.getHorario2();
		this.horario3 = obj.getHorario3();
		this.horario4 = obj.getHorario4();
		this.horario5 = obj.getHorario5();
		this.horario6 = obj.getHorario6();
		this.medico = new MedicoDTO(obj.getMedico());
		this.enfermagem = new EnfermagemDTO(obj.getEnfermagem());
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
	public MedicoDTO getMedico() {
		return medico;
	}
	public void setMedico(MedicoDTO medico) {
		this.medico = medico;
	}
	public EnfermagemDTO getEnfermagem() {
		return enfermagem;
	}
	public void setEnfermagem(EnfermagemDTO enfermagem) {
		this.enfermagem = enfermagem;
	}
	@Override
	public String toString() {
		return "PrescricaoDTO [id=" + id + ", datasistema=" + datasistema + ", via=" + via + ", freq=" + freq
				+ ", horario1=" + horario1 + ", horario2=" + horario2 + ", horario3=" + horario3 + ", horario4="
				+ horario4 + ", horario5=" + horario5 + ", horario6=" + horario6 + ", medico=" + medico
				+ ", enfermagem=" + enfermagem + "]";
	}

	
	
	
	
}
