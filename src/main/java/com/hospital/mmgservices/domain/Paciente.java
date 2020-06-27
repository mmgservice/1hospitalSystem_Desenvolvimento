package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.mmgservices.domain.enums.ResidenciaEnum;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "datasistema", nullable = true)
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

	@Column(name = "cep", length = 15, nullable = true)
	private String cep;

	@Column(name = "bairro", length = 60, nullable = true)
	private String bairro;

	@Column(name = "estadocivil", length = 20, nullable = true)
	private String estadocivil;

	@Column(name = "nomedamae", length = 50, nullable = true)
	private String nomedamae;

	@Column(name = "nomedopai", length = 50, nullable = true)
	private String nomedopai;

	@ManyToOne
	@JoinColumn(name = "cidade_id")
	@JsonIgnore
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "alergia_id")
	@JsonIgnore
	private Alergia alergia;

	@Column(name = "obs", nullable = true)
	private String obs;

	private Integer ResidenciaEnum;

	@JsonIgnore
	@OneToMany(mappedBy = "paciente")
	private List<Internacao> internacao = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "paciente")
	private List<Telefone> telefone = new ArrayList<Telefone>();

	public Paciente() {

	}

	public Paciente(Integer id, Date datasistema, String nome, String sobrenome, String datanascimento, Integer idade,
			String rg, String cpf, String sexo, String cor, String endereco, String complemento, String cep,
			String bairro, String estadocivil, String nomedamae, String nomedopai, Cidade cidade, Alergia alergia,
			String obs, ResidenciaEnum residenciaEnum, List<Internacao> internacao, List<Telefone> telefone) {
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
		this.nomedamae = nomedamae;
		this.nomedopai = nomedopai;
		this.cidade = cidade;
		this.alergia = alergia;
		this.obs = obs;
		ResidenciaEnum = (residenciaEnum == null) ? null : residenciaEnum.getCod();
		this.internacao = internacao;
		this.telefone = telefone;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
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

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getResidenciaEnum() {
		return ResidenciaEnum;
	}

	public void setResidenciaEnum(Integer residenciaEnum) {
		ResidenciaEnum = residenciaEnum;
	}

	public List<Internacao> getInternacao() {
		return internacao;
	}

	public void setInternacao(List<Internacao> internacao) {
		this.internacao = internacao;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
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
