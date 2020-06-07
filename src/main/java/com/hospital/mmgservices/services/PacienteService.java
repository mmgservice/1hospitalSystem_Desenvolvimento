package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Alergia;
import com.hospital.mmgservices.domain.Cidade;
import com.hospital.mmgservices.domain.Paciente;
import com.hospital.mmgservices.domain.Quarto;
import com.hospital.mmgservices.domain.enums.ResidenciaEnum;
import com.hospital.mmgservices.dto.PacienteDTO;
import com.hospital.mmgservices.repository.PacienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRespository;

	public List<Paciente> findAll() {
		return pacienteRespository.findAll();
	}

	public Paciente insert (Paciente obj) {
		obj.setId(null);
		return pacienteRespository.save(obj);
	}
	
	public Paciente find(Integer id) throws ObjectNotFoundException {
		Optional<Paciente> obj = pacienteRespository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Quarto.class.getName(), null));
	}

	public PacienteDTO fromDTO(Paciente paciente) {
		return new PacienteDTO(paciente);
	}

	public Paciente fromDTO(PacienteDTO objDto) {
		
	    Paciente paciente = new Paciente(objDto.getId(), objDto.getDatasistema(),
	    		objDto.getNome(), objDto.getSobrenome(), objDto.getDatanascimento(), 
	    		objDto.getIdade(), objDto.getRg(), objDto.getCpf(), 
	    		objDto.getSexo(), objDto.getCor(), objDto.getEndereco(), 
	    		objDto.getComplemento(), objDto.getCep(), objDto.getBairro(), objDto.getEstadocivil(),
	    		objDto.getNomedamae(), objDto.getNomedopai(),
	    		new Cidade(objDto.getCidade().getId(),null,null,null), 
	    		new Alergia(objDto.getAlergia().getId(),null,null),
	    		objDto.getObs(), ResidenciaEnum.toEnum(objDto.getResidenciaId()));
	    
	    return paciente;
	
	}

}
