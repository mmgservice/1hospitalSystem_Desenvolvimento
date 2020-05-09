package com.hospital.mmgservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Medicamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", length = 100 , nullable = true)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name= "categoriaMedicamento_id")
	private CategoriaMedicamento categoriamedicamento;
	
	@OneToOne(mappedBy = "medicamento")
	private Farmacia farmacia;
	
	public Medicamento() {
		
	}

	public Medicamento(Integer id, String nome, CategoriaMedicamento categoriamedicamento, Farmacia farmacia) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoriamedicamento = categoriamedicamento;
		this.farmacia = farmacia;
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

	public CategoriaMedicamento getCategoriamedicamento() {
		return categoriamedicamento;
	}

	public void setCategoriamedicamento(CategoriaMedicamento categoriamedicamento) {
		this.categoriamedicamento = categoriamedicamento;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	
}
