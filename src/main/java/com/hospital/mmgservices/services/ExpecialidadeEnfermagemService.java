package com.hospital.mmgservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public ExpecialidadeEnfermagem fromDTO(ExpecialidadeEnfermagem objDto) {
		return new ExpecialidadeEnfermagem(objDto.getId(), objDto.getExpecialidade(), objDto.getEnfermagem());
	}

	public ExpecialidadeEnfermagem fromDTO(ExpecialidadeEnfermagemDTO objDto) {
		return new ExpecialidadeEnfermagem(objDto.getId(), objDto.getExpecialidade(), null);
	}

}
