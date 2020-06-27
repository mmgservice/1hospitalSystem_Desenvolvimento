package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.ExpecialidadeEnfermagem;
import com.hospital.mmgservices.dto.ExpecialidadeEnfermagemDTO;
import com.hospital.mmgservices.repository.ExpecialidadeEnfermagemRepository;

@Service
public class ExpecialidadeEnfermagemService {

	@Autowired
	private ExpecialidadeEnfermagemRepository expecialidadeEnfermagemRepository;

	public List<ExpecialidadeEnfermagem> findAll() {
		return expecialidadeEnfermagemRepository.findAll();
	}

	public ExpecialidadeEnfermagem insert(ExpecialidadeEnfermagem obj) {
		obj.setId(null);
		return expecialidadeEnfermagemRepository.save(obj);
	}

	public ExpecialidadeEnfermagem update(ExpecialidadeEnfermagem obj) {
		ExpecialidadeEnfermagem newObj = find(obj.getId());
		updateData(newObj,obj);
		return expecialidadeEnfermagemRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			expecialidadeEnfermagemRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não possivel excluir este Enfermeiro(a)");
		}
	}
	
	public void updateData(ExpecialidadeEnfermagem newObj, ExpecialidadeEnfermagem obj) {
		newObj.setExpecialidade(obj.getExpecialidade());
	}
	public ExpecialidadeEnfermagem fromDTO(ExpecialidadeEnfermagem objDto) {
		return new ExpecialidadeEnfermagem(objDto.getId(), objDto.getExpecialidade(), objDto.getEnfermagem());
	}

	public ExpecialidadeEnfermagem fromDTO(ExpecialidadeEnfermagemDTO objDto) {
		return new ExpecialidadeEnfermagem(objDto.getId(), objDto.getExpecialidade(), null);
	}
	public ExpecialidadeEnfermagem find (Integer id) {
		Optional<ExpecialidadeEnfermagem> obj = expecialidadeEnfermagemRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ExpecialidadeEnfermagem.class.getName(), null));
	}
	

}
