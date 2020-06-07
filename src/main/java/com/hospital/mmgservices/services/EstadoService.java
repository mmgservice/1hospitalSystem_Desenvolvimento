package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Estado;
import com.hospital.mmgservices.dto.EstadoDTO;
import com.hospital.mmgservices.repository.EstadoRepository;



@Service
public class EstadoService {
     
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> findAll(){
		return estadoRepository.findAll();
	}
	
	public Estado update(Estado obj) {
		Estado newobj = find(obj.getId());
		updateData(newobj,obj);
		return estadoRepository.save(newobj);
	}
	
	public Estado insert(Estado obj) {
		obj.setId(null);
		return estadoRepository.save(obj);
	}
	
	
	public Estado find(Integer id) {
		Optional<Estado> obj = estadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName(), null));
	}
	public void delete(Integer id) {
		find(id);
		try {
			estadoRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não possivel excluir um estado");
		}
	}
	
	private void updateData(Estado newObj, Estado obj) {
		newObj.setNome(obj.getNome());
	}
	
	public Estado fromDTO(EstadoDTO objDto) {
		return new Estado(objDto.getId(),objDto.getNome(),null);
	}
	public Estado fromDTO(Estado objDto) {
		return new Estado(objDto.getId(), objDto.getNome(),objDto.getCidade());
	}
}
