package com.hospital.mmgservices.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.mmgservices.repository.UsuarioRepository;
import com.hospital.mmgservices.domain.Usuario;
import com.hospital.mmgservices.dto.UsuarioDTO;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario fromDTO(@Valid UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getUsuario(), objDto.getSenha(),null);
	}

	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = usuarioRepository.save(obj);
		return obj;
	}

}
