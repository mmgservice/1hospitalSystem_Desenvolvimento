package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Leito;
import com.hospital.mmgservices.domain.Quarto;
import com.hospital.mmgservices.domain.enums.StatusQuartoEnum;
import com.hospital.mmgservices.dto.LeitoDTO;
import com.hospital.mmgservices.repository.LeitoRepository;

@Service
public class LeitoService {

	@Autowired
	private LeitoRepository leitorepository;

	public List<Leito> findAll() {
		return leitorepository.findAll();
	}

	public Leito update(Leito obj) {
		Leito newobj = find(obj.getId());
		updateData(newobj, obj);
		return leitorepository.save(newobj);
	}

	private void updateData(Leito newobj, Leito obj) {
		
		newobj.setNomequarto(obj.getNomequarto());
		newobj.setQuarto(obj.getQuarto());	
		newobj.setStatusquartoenum(obj.getStatusquartoenum());
	}

	public void delete(Integer id) {
		find(id);
		try {
			leitorepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel deletar um Leito");
		}
	}

	public Leito insert(Leito obj) {
		obj.setId(null);
		return leitorepository.save(obj);
	}

	public LeitoDTO fromDTO(Leito leito) {
		return new LeitoDTO(leito);
	}

	public Leito fromDTO(LeitoDTO objDto) {
		Quarto quarto = new Quarto(objDto.getQuartoId(), null, null);
		return new Leito(objDto.getId(), objDto.getNomequarto(), quarto,
				StatusQuartoEnum.toEnum(objDto.getStatusquartoenum()));
	}

	public Leito find(Integer id) {
		Optional<Leito> obj = leitorepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Leito.class.getName(), null));
	}
}
