package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Paciente;

public class PacienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String datasistema;
	private String nome;
	private String sobrenome;
	private String datanascimento;
	private Integer idade;
	private String rg;
	private String cpf;
	private String sexo;
	private String cor;
	private String endereco;
	private String complemento;
	private String cep;
	private String bairro;
	private String estadocivil;
	private String obs;
	private String nomedamae;
	private String nomedopai;
	private CidadeDTO cidade;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private AlergiaDTO alergia;
	private Integer tipoSanguineoId;
	private Integer residenciaId;

	public PacienteDTO() {

	}

	public PacienteDTO(Paciente obj) {
		if (obj != null) {
			this.id = obj.getId();
			this.datasistema = obj.getDatasistema();
			this.nome = obj.getNome();
			this.sobrenome = obj.getSobrenome();
			this.datanascimento = obj.getDatanascimento();
			this.idade = obj.getIdade();
			this.rg = obj.getRg();
			this.cpf = obj.getCpf();
			this.sexo = obj.getSexo();
			this.cor = obj.getCor();
			this.endereco = obj.getEndereco();
			this.complemento = obj.getComplemento();
			this.cep = obj.getCep();
			this.bairro = obj.getCep();
			this.estadocivil = obj.getEstadocivil();
			this.obs = obj.getObs();
			this.nomedamae = obj.getNomedamae();
			this.nomedopai = obj.getNomedopai();
			this.cidade = new CidadeDTO(obj.getCidade());
			this.telefone1 = obj.getTelefone1();
			this.telefone2 = obj.getTelefone2();
			this.telefone3 = obj.getTelefone3();
			this.alergia = new AlergiaDTO(obj.getAlergia());
			this.tipoSanguineoId = obj.getTipoSanguineoEnum();
			this.residenciaId = obj.getResidenciaEnum();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDatasistema() {
		return datasistema;
	}

	public void setDatasistema(String datasistema) {
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

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
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

	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public AlergiaDTO getAlergia() {
		return alergia;
	}

	public void setAlergia(AlergiaDTO alergia) {
		this.alergia = alergia;
	}

	public Integer getTipoSanguineoId() {
		return tipoSanguineoId;
	}

	public void setTipoSanguineoId(Integer tipoSanguineoId) {
		this.tipoSanguineoId = tipoSanguineoId;
	}

	public Integer getResidenciaId() {
		return residenciaId;
	}

	public void setResidenciaId(Integer residenciaId) {
		this.residenciaId = residenciaId;
	}

	@Override
	public String toString() {
		return "PacienteDTO [id=" + id + ", datasistema=" + datasistema + ", nome=" + nome + ", sobrenome=" + sobrenome
				+ ", datanascimento=" + datanascimento + ", idade=" + idade + ", rg=" + rg + ", cpf=" + cpf + ", sexo="
				+ sexo + ", cor=" + cor + ", endereco=" + endereco + ", complemento=" + complemento + ", cep=" + cep
				+ ", bairro=" + bairro + ", estadocivil=" + estadocivil + ", obs=" + obs + ", nomedamae=" + nomedamae
				+ ", nomedopai=" + nomedopai + ", cidade=" + cidade + ", alergia=" + alergia + ", residenciaId="
				+ residenciaId + "]";
	}

}
