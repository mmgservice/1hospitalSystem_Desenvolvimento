package com.hospital.mmgservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.ExpecialidadeMedico;
import com.hospital.mmgservices.domain.Medico;
import com.hospital.mmgservices.dto.MedicoDTO;
import com.hospital.mmgservices.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	public List<Medico> findAll(){
		return medicoRepository.findAll();
	}
	public Medico insert(Medico obj) {
		obj.setId(null);
		return medicoRepository.save(obj);
	}
	public MedicoDTO fromDTO(Medico medico) {
		return new MedicoDTO(medico);
	}
	public Medico fromDTO(MedicoDTO objDto) {
		return new Medico(objDto.getId(),objDto.getNome(),objDto.getCrm(), new ExpecialidadeMedico(objDto.getExpecialidadeId(),null,null));
	}
}
