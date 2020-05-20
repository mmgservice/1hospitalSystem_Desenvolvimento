package com.hospital.mmgservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.CategoriaMedicamento;
import com.hospital.mmgservices.dto.CategoriaMedicamentoDTO;
import com.hospital.mmgservices.repository.CategoriaMedicamentoRepository;

@Service
public class CategoriaMedicamentoService {

	@Autowired
	private CategoriaMedicamentoRepository categoriaedicamentorepository;
	
	public List<CategoriaMedicamento> findAll(){
		return categoriaedicamentorepository.findAll();
	}
	
	public CategoriaMedicamento insert(CategoriaMedicamento obj) {
		obj.setId(null);
		return categoriaedicamentorepository.save(obj);
	}
	public CategoriaMedicamento fromDTO(CategoriaMedicamentoDTO objDto) {
		return new CategoriaMedicamento(objDto.getId(),objDto.getDescricao(),null);
	}
	public CategoriaMedicamento fromDTO(CategoriaMedicamento objDto) {
		return new CategoriaMedicamento(objDto.getId(),objDto.getDescricao(),null);
	}
	
}
