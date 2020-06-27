package com.hospital.mmgservices.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hospital.mmgservices.domain.Farmacia;
import com.hospital.mmgservices.dto.FarmaciaDTO;
import com.hospital.mmgservices.services.FarmaciaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/farmacia")
public class FarmaciaResource {

	@Autowired
	private FarmaciaService farmaciaservice;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Farmacia> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Farmacia obj = farmaciaservice.find(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FarmaciaDTO>> findAll() {
		List<Farmacia> list = farmaciaservice.findAll();
		List<FarmaciaDTO> listDTO = list.stream().map(obj -> new FarmaciaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FarmaciaDTO objDto) {
		Farmacia obj = farmaciaservice.fromDTO(objDto);
		obj = farmaciaservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FarmaciaDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException {
		Farmacia obj = farmaciaservice.fromDTO(objDto);
		obj.setId(id);
		obj = farmaciaservice.update(obj);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException {
		farmaciaservice.delete(id);
		return ResponseEntity.noContent().build();
	}
}
