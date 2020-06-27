package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Telefone;
import com.hospital.mmgservices.repository.TelefoneRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;

	public List<Telefone> findAll() {
		return telefoneRepository.findAll();
	}

	public Telefone find(Integer id) throws ObjectNotFoundException {
		Optional<Telefone> obj = telefoneRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Telefone.class.getName(), null));
	}
}
