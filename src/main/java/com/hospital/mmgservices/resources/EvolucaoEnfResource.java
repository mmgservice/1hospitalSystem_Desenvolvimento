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

import com.hospital.mmgservices.domain.EvolucaoEnfermagem;
import com.hospital.mmgservices.dto.EvolucaoEnfermagemDTO;
import com.hospital.mmgservices.services.EvolucaoEnfService;

@RestController
@RequestMapping(value = "/evolucaoenf")
public class EvolucaoEnfResource {

	@Autowired
	private EvolucaoEnfService evolucaoenfservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EvolucaoEnfermagemDTO>> findAll() {
		List<EvolucaoEnfermagem> list = evolucaoenfservice.findAll();
		List<EvolucaoEnfermagemDTO> listDTO = list.stream().map(obj -> new EvolucaoEnfermagemDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EvolucaoEnfermagemDTO objDto) {
		EvolucaoEnfermagem obj = evolucaoenfservice.fromDTO(objDto);
		obj = evolucaoenfservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EvolucaoEnfermagemDTO objDto, @PathVariable Integer id) {
		EvolucaoEnfermagem obj = evolucaoenfservice.fromDTO(objDto);
		obj.setId(id);
		obj = evolucaoenfservice.update(obj);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		evolucaoenfservice.delete(id);
		return ResponseEntity.noContent().build();
	}
}
