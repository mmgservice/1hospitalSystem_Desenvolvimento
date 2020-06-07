package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ExpecialidadeMedico fromDTO(ExpecialidadeMedico objDto) {
    	return new ExpecialidadeMedico(objDto.getId(),objDto.getExpecialidade(),objDto.getMedico());
    }
    public ExpecialidadeMedico fromDTO(ExpecialidadeMedicoDTO objDto) {
    	return new ExpecialidadeMedico(objDto.getId(),objDto.getExpecialidade(),null);
    }
}
