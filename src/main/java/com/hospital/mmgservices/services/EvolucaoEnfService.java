package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Enfermagem;
import com.hospital.mmgservices.domain.EvolucaoEnfermagem;
import com.hospital.mmgservices.dto.EvolucaoEnfermagemDTO;
import com.hospital.mmgservices.repository.EvolucaoEnfRepository;

@Service
public class EvolucaoEnfService {

	@Autowired
	private EvolucaoEnfRepository evolucaoenfRepo;
	
	public List<EvolucaoEnfermagem> findAll(){
		return evolucaoenfRepo.findAll();
	}
	
	
	public EvolucaoEnfermagem update(EvolucaoEnfermagem obj) {
		EvolucaoEnfermagem newobj = find(obj.getId());
		updateData(newobj, obj);
		return evolucaoenfRepo.save(newobj);
	}

	public EvolucaoEnfermagem insert(EvolucaoEnfermagem obj) {
		obj.setId(null);
		return evolucaoenfRepo.save(obj);
	}

	public EvolucaoEnfermagemDTO fromDTO(EvolucaoEnfermagem evolucaoEnf) {
		return new EvolucaoEnfermagemDTO(evolucaoEnf);
	}

	public EvolucaoEnfermagem find(Integer id) {
		Optional<EvolucaoEnfermagem> obj = evolucaoenfRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + EvolucaoEnfermagem.class.getName(), null));
	}

	public void delete(Integer id) {
		find(id);
		try {
			evolucaoenfRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não possivel excluir um Cidade");
		}
	}

	private void updateData(EvolucaoEnfermagem newObj, EvolucaoEnfermagem obj) {
		newObj.setEvolucaoenf(obj.getEvolucaoenf());
	}

	public EvolucaoEnfermagem fromDTO(EvolucaoEnfermagemDTO objDto) {
		return new EvolucaoEnfermagem(objDto.getId(),
				                      objDto.getEvolucaoenf(),
				                      objDto.getDataevolucao(),
				                      new Enfermagem(objDto.getEnfermagem().getId(),null,null,null,null));
	}
}
