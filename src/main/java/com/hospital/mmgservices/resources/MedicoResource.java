package com.hospital.mmgservices.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hospital.mmgservices.domain.Medico;
import com.hospital.mmgservices.dto.MedicoDTO;
import com.hospital.mmgservices.services.MedicoService;

@RestController
@RequestMapping(value="/medicos")
public class MedicoResource {
	
	@Autowired
	private MedicoService medicoservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MedicoDTO>> findAll() {
		List<Medico> list = medicoservice.findAll();
		List<MedicoDTO> listDTO = list.stream().map(obj -> new MedicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MedicoDTO objDto) {
		Medico obj = medicoservice.fromDTO(objDto);
		obj = medicoservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
