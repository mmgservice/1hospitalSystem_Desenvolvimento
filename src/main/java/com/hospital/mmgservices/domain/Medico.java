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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", length = 50, nullable = true)
	private String nome;

	@Column(name = "crm", length = 50, nullable = true)
	private String crm;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "expecialidade_id")
	private ExpecialidadeMedico expecialidademedico;

	@OneToMany(mappedBy = "medico")
	private List<Exame> exame = new ArrayList<>();

	@OneToMany(mappedBy = "medico")
	private List<Prescricao> prescricao = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "medico")
	private List<EvolucaoMedico> evolucaoMedico = new ArrayList<>();

	public Medico() {

	}

	public Medico(Integer id, String nome, String crm, ExpecialidadeMedico expecialidademedico, List<Exame> exame,
			List<Prescricao> prescricao, List<EvolucaoMedico> evolucaoMedico) {
		super();
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.expecialidademedico = expecialidademedico;
		this.exame = exame;
		this.prescricao = prescricao;
		this.evolucaoMedico = evolucaoMedico;
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public ExpecialidadeMedico getExpecialidademedico() {
		return expecialidademedico;
	}

	public void setExpecialidademedico(ExpecialidadeMedico expecialidademedico) {
		this.expecialidademedico = expecialidademedico;
	}

	public List<Exame> getExame() {
		return exame;
	}

	public void setExame(List<Exame> exame) {
		this.exame = exame;
	}

	public List<Prescricao> getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(List<Prescricao> prescricao) {
		this.prescricao = prescricao;
	}

	public List<EvolucaoMedico> getEvolucaoMedico() {
		return evolucaoMedico;
	}

	public void setEvolucaoMedico(List<EvolucaoMedico> evolucaoMedico) {
		this.evolucaoMedico = evolucaoMedico;
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
		Medico other = (Medico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
