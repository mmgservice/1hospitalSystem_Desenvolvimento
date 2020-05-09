package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Quarto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", length = 20, nullable = true)
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "statusquarto_id")
	private StatusQuarto statusquarto;
	

	 @ManyToMany
	 @JoinColumn(name = "ala_id")
	 private List<Ala> ala = new ArrayList<>(); 

	
	public Quarto () {
		
	}


	public Quarto(Integer id, String nome, StatusQuarto statusquarto, List<Ala> ala) {
		super();
		this.id = id;
		this.nome = nome;
		this.statusquarto = statusquarto;
		this.ala = ala;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public StatusQuarto getStatusquarto() {
		return statusquarto;
	}


	public void setStatusquarto(StatusQuarto statusquarto) {
		this.statusquarto = statusquarto;
	}


	public List<Ala> getAla() {
		return ala;
	}


	public void setAla(List<Ala> ala) {
		this.ala = ala;
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
		Quarto other = (Quarto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
