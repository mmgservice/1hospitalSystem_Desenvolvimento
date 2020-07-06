package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Exame;
import com.hospital.mmgservices.domain.Medico;
import com.hospital.mmgservices.domain.NomeExame;
import com.hospital.mmgservices.domain.Paciente;
import com.hospital.mmgservices.domain.enums.StatusExameEnum;
import com.hospital.mmgservices.dto.ExameDTO;
import com.hospital.mmgservices.repository.ExameRepository;

@Service
public class ExameService {

	@Autowired
	private ExameRepository exameRepository;

	public List<Exame> findAll() {
		return exameRepository.findAll();
	}

	public Exame insert(Exame obj) {
		obj.setId(null);
		return exameRepository.save(obj);
	}

	public ExameDTO fromDTO(Exame exame) {
		return new ExameDTO(exame);
	}
	
	public Exame update(Exame obj) {
		Exame newobj = find(obj.getId());
		updateData(newobj, obj);
		return exameRepository.save(newobj);
	}
	
	private void updateData(Exame newObj, Exame obj) {
		newObj.setDatasistema(obj.getDatasistema());
		newObj.setDataexame(obj.getDataexame());
		newObj.setHorario(obj.getHorario());
		newObj.setNomeexame(obj.getNomeexame());
		newObj.setStatusExameEnum(obj.getStatusExameEnum());
		newObj.setPaciente(obj.getPaciente());
		newObj.setMedico(obj.getMedico());
		
	}
	
	
	public Exame find(Integer id) {
		Optional<Exame> obj = exameRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Exame.class.getName(), null));
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			exameRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não possivel excluir este Exame");
		}
	}

	public Exame fromDTO(ExameDTO objDTO) {
		Exame exame = new Exame(objDTO.getId(),objDTO.getDatasistema(),objDTO.getDataexame(),objDTO.getHorario(),
				new NomeExame(objDTO.getNomeexame().getId(), null, null, null),
				StatusExameEnum.toEnum(objDTO.getStatusExameId()),
				new Paciente(objDTO.getPaciente().getId(), null, objDTO.getPaciente().getNome(), null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null),
				new Medico(objDTO.getMedico().getId(), objDTO.getMedico().getNome(), null, null, null, null, null));

		return exame;
	}

}
