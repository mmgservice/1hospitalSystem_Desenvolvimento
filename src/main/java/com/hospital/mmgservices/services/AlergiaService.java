package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Alergia;
import com.hospital.mmgservices.dto.AlergiaDTO;
import com.hospital.mmgservices.repository.AlergiaRepository;

@Service
public class AlergiaService {

	@Autowired
	private AlergiaRepository alergiaRepository;

	public List<Alergia> findAll() {
		return alergiaRepository.findAll();
	}

	public Alergia find(Integer id) {
		Optional<Alergia> obj = alergiaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Alergia.class.getName(), null));
	}

	public Alergia fromDTO(AlergiaDTO objDto) {
		return new Alergia(objDto.getId(), objDto.getNome(), null);
	}

	public Alergia insert(Alergia obj) {
		obj.setId(null);
		obj = alergiaRepository.save(obj);
		return obj;
	}

	public Alergia update(Alergia obj) {
		return alergiaRepository.save(obj);
	}

	public void delete(Integer id) {
		alergiaRepository.deleteById(id);
	}
}
