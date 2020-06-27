package com.hospital.mmgservices.dto;

import java.io.Serializable;

import com.hospital.mmgservices.domain.Usuario;


public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private Integer id;
	private String usuario;
	private String senha;
	private Integer perfil; 
	
	public UsuarioDTO(Usuario obj) {
		this.id = obj.getId();
		this.usuario = obj.getUsuario();
		this.senha = obj.getSenha();
		this.perfil = obj.getPerfil();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

}
