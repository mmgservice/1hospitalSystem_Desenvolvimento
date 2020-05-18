package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Quarto;
import com.hospital.mmgservices.dto.QuartoDTO;
import com.hospital.mmgservices.repository.QuartoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository quartorepository;
	
	public List<Quarto> findAll() {
		return quartorepository.findAll();
	}
	
	public Quarto insert(Quarto obj) {
		obj.setId(null);
		return quartorepository.save(obj);
	}
	public QuartoDTO fromDTO(Quarto quarto) {
		return new QuartoDTO(quarto);
	}
	public Quarto fromDTO(QuartoDTO objDto) {
		return new Quarto(objDto.getId(),objDto.getNome(),null);
	}
	public Quarto find(Integer id) throws ObjectNotFoundException {
		Optional<Quarto> obj = quartorepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Quarto.class.getName(), null));
	}
	public Quarto update (Quarto obj) throws ObjectNotFoundException {
		Quarto newObj = find(obj.getId());
		updateData(newObj, obj);
		return quartorepository.save(newObj);
	}
	
	private void updateData(Quarto newObj, Quarto obj) {
		newObj.setNome(obj.getNome());
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
		  quartorepository.deleteById(id);
		}catch(DataIntegrityViolationException e){
			throw new DataIntegrityViolationException("Não é possivel deletar este quarto");
		}
	}
}
