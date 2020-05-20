package com.hospital.mmgservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Enfermagem;
import com.hospital.mmgservices.domain.ExpecialidadeEnfermagem;
import com.hospital.mmgservices.dto.EnfermagemDTO;
import com.hospital.mmgservices.repository.EnfermagemRepository;

@Service
public class EnfermagemService {

	@Autowired
	private EnfermagemRepository enfermagemRepository;

	public List<Enfermagem> findAll() {
		return enfermagemRepository.findAll();
	}

	public Enfermagem insert(Enfermagem obj) {
		obj.setId(null);
		return enfermagemRepository.save(obj);
	}

	public EnfermagemDTO fromDTO(Enfermagem enfermagem) {
		return new EnfermagemDTO(enfermagem);
	}

	public Enfermagem fromDTO(EnfermagemDTO objDto) {
		return new Enfermagem(objDto.getId(), objDto.getNome(), objDto.getCoren(),new ExpecialidadeEnfermagem(objDto.getExpecialidadeId(), null, null));
	}
}
