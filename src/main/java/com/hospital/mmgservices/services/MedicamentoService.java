package com.hospital.mmgservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.CategoriaMedicamento;
import com.hospital.mmgservices.domain.Medicamento;
import com.hospital.mmgservices.dto.MedicamentoDTO;
import com.hospital.mmgservices.repository.MedicamentoRepository;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository medicamentorepository;
	
	public List<Medicamento> findAll(){
		return medicamentorepository.findAll();
	}
	public Medicamento insert(Medicamento obj) {
		obj.setId(null);
		return medicamentorepository.save(obj);
	}
	public MedicamentoDTO fromDTO(Medicamento medicamento) {
		return new MedicamentoDTO(medicamento);
	}
	public Medicamento fromDTO(MedicamentoDTO objDto) {
		return new Medicamento(objDto.getId(),objDto.getNome(),new CategoriaMedicamento(objDto.getCategoriaId(),null,null),null);
	}
}
