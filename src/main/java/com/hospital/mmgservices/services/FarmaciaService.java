package com.hospital.mmgservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Farmacia;
import com.hospital.mmgservices.domain.Medicamento;
import com.hospital.mmgservices.dto.FarmaciaDTO;
import com.hospital.mmgservices.repository.FarmaciaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FarmaciaService {

	@Autowired
	private FarmaciaRepository farmaciarepository;
	
	public List<Farmacia> findAll(){
		return farmaciarepository.findAll();
	}
	
	public Farmacia insert(Farmacia obj) {
		obj.setId(null);
		return farmaciarepository.save(obj);
	}
	public FarmaciaDTO fromDTO(Farmacia farmacia) {
		return new FarmaciaDTO(farmacia);
	}
	public Farmacia update(Farmacia obj) throws ObjectNotFoundException {
		Farmacia newObj = find(obj.getId());
		updateData(newObj,obj);
		return farmaciarepository.save(newObj);
	}
	public void updateData(Farmacia newObj,Farmacia obj) {
		newObj.setMedicamento(obj.getMedicamento());
		newObj.setDatasistema(obj.getDatasistema());
		newObj.setDosagem(obj.getDosagem());
		newObj.setQuantidade(obj.getQuantidade());
		newObj.setQuantidadetotal(obj.getQuantidadetotal());
		newObj.setDatavencimento(obj.getDatavencimento());
		newObj.setValor(obj.getValor());
		newObj.setValortotal(obj.getValortotal());
	}
	
	public Farmacia find(Integer id) throws ObjectNotFoundException {
		Optional<Farmacia> obj = farmaciarepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id" + id + ",Tipo: "+ Farmacia.class.getName(), null));
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
			farmaciarepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não Possivel Excluir uma Cidade");
		}
	}
	public Farmacia fromDTO(FarmaciaDTO objDto) {
		return new Farmacia(objDto.getId(),
				            objDto.getDatasistema(),
				            objDto.getDosagem(),
				            objDto.getQuantidade(),
				            objDto.getQuantidadetotal(),
				            objDto.getDatavencimento(),
				            objDto.getValor(),
				            objDto.getValortotal(),new Medicamento(objDto.getMedicamento().getId(),objDto.getMedicamento().getNome(),null,null));
	}
}
