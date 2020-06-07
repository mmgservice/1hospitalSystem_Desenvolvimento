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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "medicamento")
	private List<Farmacia> farmacia = new ArrayList<>();
	
	
	public Medicamento() {
		
	}

	public Medicamento(Integer id, String nome, CategoriaMedicamento categoriamedicamento, List<Farmacia> farmacia) {
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

	public List<Farmacia> getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(List<Farmacia> farmacia) {
		this.farmacia = farmacia;
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
		Medicamento other = (Medicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
