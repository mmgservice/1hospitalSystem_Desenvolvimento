package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date datasistema;

	@Column(name = "nome", length = 50, nullable = true)
	private String nome;

	@Column(name = "sobrenome", length = 50, nullable = true)
	private String sobrenome;

	@Column(name = "datanascimento", length = 10, nullable = true)
	private String datanascimento;

	@Column(name = "idade", length = 110, nullable = true)
	private Integer idade;

	@Column(name = "rg", length = 15, nullable = true)
	private String rg;

	@Column(name = "cpf", length = 15, nullable = true)
	private String cpf;

	@Column(name = "sexo", length = 10, nullable = true)
	private String sexo;

	@Column(name = "cor", length = 20, nullable = true)
	private String cor;

	@Column(name = "endereco", length = 50, nullable = true)
	private String endereco;

	@Column(name = "complemento", length = 50, nullable = false)
	private String complemento;

	@Column(name = "cep", length = 8, nullable = true)
	private Integer cep;

	@Column(name = "bairro", length = 60, nullable = true)
	private String bairro;

	@Column(name = "estadocivil", length = 20, nullable = true)
	private String estadocivil;

	@ElementCollection
	@CollectionTable(name = "telefone")
	@Column(length = 15, nullable = true)
	private Set<String> telefones = new HashSet<String>();

	@Column(name = "nomedamae", length = 50, nullable = true)
	private String nomedamae;

	@Column(name = "nomedopai", length = 50, nullable = true)
	private String nomedopai;
	
	@OneToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	@OneToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	@OneToOne
	@JoinColumn(name = "alergia_id")
	private Alergia alergia;
	
	@OneToOne
	@JoinColumn(name = "residencia_id")
	private Residencia residencia;
	
	public Paciente() {

	}

	public Paciente(Integer id, Date datasistema, String nome, String sobrenome, String datanascimento, Integer idade,
			String rg, String cpf, String sexo, String cor, String endereco, String complemento, Integer cep,
			String bairro, String estadocivil, Set<String> telefones, String nomedamae, String nomedopai, Cidade cidade,
			Estado estado, Alergia alergia, Residencia residencia) {
		super();
		this.id = id;
		this.datasistema = datasistema;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.datanascimento = datanascimento;
		this.idade = idade;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.cor = cor;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.estadocivil = estadocivil;
		this.telefones = telefones;
		this.nomedamae = nomedamae;
		this.nomedopai = nomedopai;
		this.cidade = cidade;
		this.estado = estado;
		this.alergia = alergia;
		this.residencia = residencia;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public String getNomedamae() {
		return nomedamae;
	}

	public void setNomedamae(String nomedamae) {
		this.nomedamae = nomedamae;
	}

	public String getNomedopai() {
		return nomedopai;
	}

	public void setNomedopai(String nomedopai) {
		this.nomedopai = nomedopai;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	public Residencia getResidencia() {
		return residencia;
	}

	public void setResidencia(Residencia residencia) {
		this.residencia = residencia;
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
