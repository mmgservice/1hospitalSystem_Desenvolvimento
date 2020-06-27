package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.ExpecialidadeMedico;
import com.hospital.mmgservices.domain.Medico;
import com.hospital.mmgservices.dto.MedicoDTO;
import com.hospital.mmgservices.repository.MedicoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	public List<Medico> findAll() {
		return medicoRepository.findAll();
	}

	public Medico insert(Medico obj) {
		obj.setId(null);
		return medicoRepository.save(obj);
	}

	public Medico update(Medico obj) throws ObjectNotFoundException {
		Medico newobj = find(obj.getId());
		updateData(newobj, obj);
		return medicoRepository.save(newobj);
	}

	private void updateData(Medico newObj, Medico obj) {
		newObj.setNome(obj.getNome());
	}

	public Medico find(Integer id) throws ObjectNotFoundException {
		Optional<Medico> obj = medicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Medico.class.getName(), null));
	}

	
	 public void delete(Integer id) throws ObjectNotFoundException {
			find(id);
			try {
				medicoRepository.deleteById(id);
			}
			catch(DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("Não possivel excluir este Médico(a)");
			}
		}

	public MedicoDTO fromDTO(Medico medico) {
		return new MedicoDTO(medico);
	}

	public Medico fromDTO(MedicoDTO objDto) {
		return new Medico(objDto.getId(), objDto.getNome(), objDto.getCrm(),
				new ExpecialidadeMedico(objDto.getExpecialidade().getId(), objDto.getExpecialidade().getExpecialidade(), null), null, null, null);
	}
}
