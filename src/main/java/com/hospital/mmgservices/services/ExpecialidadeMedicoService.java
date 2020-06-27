package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.ExpecialidadeMedico;
import com.hospital.mmgservices.dto.ExpecialidadeMedicoDTO;
import com.hospital.mmgservices.repository.ExpecialidadeMedicoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ExpecialidadeMedicoService {
	
    @Autowired
	private ExpecialidadeMedicoRepository expecialidademedicorepository;
    
    public List<ExpecialidadeMedico> findAll(){
    	return expecialidademedicorepository.findAll();
    }
    
    public ExpecialidadeMedico find(Integer id) throws ObjectNotFoundException {
    	Optional<ExpecialidadeMedico> obj = expecialidademedicorepository.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException(
    			"Objeto não encontrado ! Id:" + id + ", Tipo: " + ExpecialidadeMedico.class.getName(),null)); 
    }  
    
    public ExpecialidadeMedico insert(ExpecialidadeMedico obj) {
    	obj.setId(null);
    	return expecialidademedicorepository.save(obj);
    }
    
    public ExpecialidadeMedico update(ExpecialidadeMedico obj) throws ObjectNotFoundException {
    	ExpecialidadeMedico newObj = find(obj.getId());
    	updateData(newObj,obj);
		return expecialidademedicorepository.save(newObj);
	}
    
    public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
			expecialidademedicorepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não possivel excluir esta expecialidade da medicina");
		}
	}
    
    public void updateData(ExpecialidadeMedico newObj, ExpecialidadeMedico obj) {
		newObj.setExpecialidade(obj.getExpecialidade());
	}
	
    public ExpecialidadeMedico fromDTO(ExpecialidadeMedico objDto) {
    	return new ExpecialidadeMedico(objDto.getId(),objDto.getExpecialidade(),objDto.getMedico());
    }
    public ExpecialidadeMedico fromDTO(ExpecialidadeMedicoDTO objDto) {
    	return new ExpecialidadeMedico(objDto.getId(),objDto.getExpecialidade(),null);
    }
}
