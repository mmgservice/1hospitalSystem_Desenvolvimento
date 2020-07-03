package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	public Medicamento update(Medicamento obj) {
		Medicamento newobj = find(obj.getId());
		updateData(newobj,obj);
		return medicamentorepository.save(newobj);
	}
	private void updateData(Medicamento newobj, Medicamento obj) {
	     newobj.setNome(obj.getNome());
	     newobj.setCategoriamedicamento(obj.getCategoriamedicamento());
	}
	public MedicamentoDTO fromDTO(Medicamento medicamento) {
		return new MedicamentoDTO(medicamento);
	}
	public Medicamento fromDTO(MedicamentoDTO objDto) {
		return new Medicamento(objDto.getId(),objDto.getNome(),
				                new CategoriaMedicamento(objDto.getCategoriamedicamento().getId(),
				                                         objDto.getCategoriamedicamento().getNome(),null),null);
	}
	public Medicamento find(Integer id) {
		Optional<Medicamento> obj = medicamentorepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Medicamento.class.getName(), null));
	}
	public void delete(Integer id) {
		find(id);
		try {
			medicamentorepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um medicamento");
		}
	}
}
