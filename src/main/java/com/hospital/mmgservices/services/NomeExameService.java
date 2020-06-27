package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.hospital.mmgservices.domain.CategoriaExame;
import com.hospital.mmgservices.domain.NomeExame;
import com.hospital.mmgservices.dto.NomeExameDTO;
import com.hospital.mmgservices.repository.NomeExameRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class NomeExameService {

	@Autowired
	private NomeExameRepository nomeExameRepository;

	public List<NomeExame> findAll() {
		return nomeExameRepository.findAll();
	}

	public NomeExame find(Integer id) throws ObjectNotFoundException {
		Optional<NomeExame> obj = nomeExameRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id :" + id + ", Tipo: " + NomeExame.class.getName(), null));
	}

	public NomeExameDTO fromDTO(NomeExame nomeExame) {
		return new NomeExameDTO(nomeExame);
	}

	public NomeExame fromDTO(NomeExameDTO objDto) {
		NomeExame nomeExame = new NomeExame(objDto.getId(), objDto.getNomedoexame(), objDto.getValor(),
				new CategoriaExame(objDto.getCategoriaExame().getId(), objDto.getNomedoexame(), null));
		return nomeExame;
	}

	public NomeExame insert(NomeExame obj) throws ObjectNotFoundException {
		obj.setId(null);
		obj = nomeExameRepository.save(obj);
		return obj;
	}

	public NomeExame upate(NomeExame obj) throws ObjectNotFoundException {
		NomeExame newObj = find(obj.getId());
		updateData(newObj, obj);
		return nomeExameRepository.save(newObj);
	}

	private void updateData(NomeExame newObj, NomeExame obj) {
		newObj.setNomedoexame(obj.getNomedoexame());
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
			nomeExameRepository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir não encontrado!");
		}

	}

}
