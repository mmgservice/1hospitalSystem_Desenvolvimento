package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		return new Enfermagem(objDto.getId(), objDto.getNome(), objDto.getCoren(),
				new ExpecialidadeEnfermagem(objDto.getExpecialidade().getId(), objDto.getExpecialidade().getExpecialidade(), null), null);
	}

	public Enfermagem find(Integer id) {
		Optional<Enfermagem> obj = enfermagemRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Enfermagem.class.getName(), null));
	}

	public Enfermagem update(Enfermagem obj) {
		Enfermagem newobj = find(obj.getId());
		updateData(newobj, obj);
		return enfermagemRepository.save(newobj);
	}

	private void updateData(Enfermagem newObj, Enfermagem obj) {
		newObj.setNome(obj.getNome());
	}

	public void delete(Integer id) {
		find(id);
		try {
			enfermagemRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não possilvel exluir esta expecialidade da Enfermagem");
		}
	}

}
