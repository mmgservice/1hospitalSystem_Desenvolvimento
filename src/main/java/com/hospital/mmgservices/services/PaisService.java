package com.hospital.mmgservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Pais;
import com.hospital.mmgservices.repository.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;

	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

	/*
	 * public List<Cidade> findByEstado(Integer estadoId) { return
	 * repo.findCidades(estadoId); }
	 * 
	 */

}
