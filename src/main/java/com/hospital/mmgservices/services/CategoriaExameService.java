package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.hospital.mmgservices.domain.CategoriaExame;
import com.hospital.mmgservices.dto.CategoriaExameDTO;
import com.hospital.mmgservices.repository.CategoriaExameRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaExameService {

	@Autowired
	private CategoriaExameRepository categoriaExameRepository;

	public List<CategoriaExame> findAll() {
		return categoriaExameRepository.findAll();
	}

	public CategoriaExame find(Integer id) throws ObjectNotFoundException {
		Optional<CategoriaExame> obj = categoriaExameRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaExame.class.getName()));

	}

	public CategoriaExameDTO fromDTO(CategoriaExame categoriaexame) {
		return new CategoriaExameDTO(categoriaexame);
	}

	public CategoriaExame fromDto(CategoriaExameDTO objDTO) {
		return new CategoriaExame(objDTO.getId(), objDTO.getNome(), null);
	}

	public CategoriaExame insert(CategoriaExame obj) throws ObjectNotFoundException {
		obj.setId(null);
		obj = categoriaExameRepository.save(obj);
		return obj;
	}

	public CategoriaExame upate(CategoriaExame obj) throws ObjectNotFoundException {
		CategoriaExame newObj = find(obj.getId());
		update(newObj, obj);
		return categoriaExameRepository.save(newObj);
	}

	private void update(CategoriaExame newObj, CategoriaExame obj) {
		newObj.setNome(obj.getNome());

	}

	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
			categoriaExameRepository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir não encontrado!");
		}

	}

}
