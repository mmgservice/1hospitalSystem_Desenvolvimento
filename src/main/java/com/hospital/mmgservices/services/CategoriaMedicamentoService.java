package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	public void delete(Integer id) {
		find(id);
		try {
			categoriaedicamentorepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não possivel excluir um Cidade");
		}
	}
	public CategoriaMedicamento find(Integer id) {
		Optional<CategoriaMedicamento> obj = categoriaedicamentorepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaMedicamento.class.getName(), null));
	}
	
	public CategoriaMedicamento fromDTO(CategoriaMedicamento objDto) {
		return new CategoriaMedicamento(objDto.getId(),objDto.getDescricao(),null);
	}
	
	private void updateData(CategoriaMedicamento newObj, CategoriaMedicamento obj) {
		newObj.setDescricao(obj.getDescricao());
	}
	
	public CategoriaMedicamento update(CategoriaMedicamento obj) {
		CategoriaMedicamento newobj = find(obj.getId());
		updateData(newobj, obj);
		return categoriaedicamentorepository.save(newobj);
	}
}
