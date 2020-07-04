package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Enfermagem;
import com.hospital.mmgservices.domain.Medico;
import com.hospital.mmgservices.domain.Prescricao;
import com.hospital.mmgservices.dto.PrescricaoDTO;
import com.hospital.mmgservices.repository.PrescricaoRepository;

@Service
public class PrescricaoService {

	@Autowired
	private PrescricaoRepository repo;
	
	public List<Prescricao> findAll(){
		return repo.findAll();
	}
	public Prescricao update(Prescricao obj) {
		Prescricao newobj = find(obj.getId());
		updateData(newobj,obj);
		return repo.save(newobj);
	}
	public Prescricao find(Integer id) {
		Optional<Prescricao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Prescricao.class.getName(), null));
	}
    public void updateData(Prescricao newObj, Prescricao obj) {
    	newObj.setFreq(obj.getFreq());
    	newObj.setVia(obj.getVia());
    	newObj.setHorario1(obj.getHorario1());
    	newObj.setHorario2(obj.getHorario2());
    	newObj.setHorario3(obj.getHorario3());
    	newObj.setHorario4(obj.getHorario4());
    	newObj.setHorario5(obj.getHorario5());
    	newObj.setHorario6(obj.getHorario6());
    	newObj.setMedico(obj.getMedico());
    	newObj.setEnfermagem(obj.getEnfermagem());
    }
    public PrescricaoDTO fromDTO(Prescricao prescricao) {
    	return new PrescricaoDTO(prescricao);
    }
    public Prescricao insert(Prescricao obj) {
    	obj.setId(null);
    	return repo.save(obj);
    }
    public Prescricao fromDTO(PrescricaoDTO objDto) {
    	Medico medico = new Medico(objDto.getMedico().getId(),
    			                   objDto.getMedico().getNome(),
    			                   objDto.getMedico().getCrm(),null,null,null,null);
    	
    	Enfermagem enfemagem = new Enfermagem(objDto.getEnfermagem().getId(),
    										  objDto.getEnfermagem().getNome(),
    										  objDto.getEnfermagem().getCoren(),null,null);
    	
    	Prescricao prescricao = new Prescricao(objDto.getId(),
    			 							  objDto.getDatasistema(),
    			 							  objDto.getVia(),
    			 							  objDto.getFreq(),
    			 							  objDto.getHorario1(),
    			 							  objDto.getHorario2(),
    			 							  objDto.getHorario3(),
    			 							  objDto.getHorario4(),
    			 							  objDto.getHorario5(),
    			 							  objDto.getHorario6(),medico,enfemagem);
    	if(objDto.getHorario4() != null) {
			prescricao.setHorario4(objDto.getHorario4());
		}
    	if(objDto.getHorario5() != null) {
			prescricao.setHorario5(objDto.getHorario5());
		}
    	if(objDto.getHorario6() != null) {
			prescricao.setHorario6(objDto.getHorario6());
		}
    	
    	
    	return prescricao;
    }
    public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir uma prescricao");
		}
	}
}
