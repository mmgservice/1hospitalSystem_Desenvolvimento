package com.hospital.mmgservices.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hospital.mmgservices.domain.ExpecialidadeMedico;
import com.hospital.mmgservices.dto.ExpecialidadeMedicoDTO;
import com.hospital.mmgservices.services.ExpecialidadeMedicoService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/expecialidademedicos")
public class ExpecialidadeMedicoResource {

	@Autowired
	private ExpecialidadeMedicoService expecialidademedicoservice;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ExpecialidadeMedico objDto) {
		ExpecialidadeMedico obj = expecialidademedicoservice.fromDTO(objDto);
		obj = expecialidademedicoservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExpecialidadeMedicoDTO>> findAll() {
		List<ExpecialidadeMedico> list = expecialidademedicoservice.findAll();
		List<ExpecialidadeMedicoDTO> listDTO = list.stream().map(obj -> new ExpecialidadeMedicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
