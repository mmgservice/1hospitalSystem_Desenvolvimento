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
import com.hospital.mmgservices.domain.Enfermagem;
import com.hospital.mmgservices.dto.EnfermagemDTO;
import com.hospital.mmgservices.services.EnfermagemService;

@RestController
@RequestMapping(value="/enfermagem")
public class EnfermagemResource {
     
	@Autowired
	private EnfermagemService enfermagemService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EnfermagemDTO>> findAll() {
		List<Enfermagem> list = enfermagemService.findAll();
		List<EnfermagemDTO> listDTO = list.stream().map(obj -> new EnfermagemDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EnfermagemDTO objDto) {
		Enfermagem obj = enfermagemService.fromDTO(objDto);
		obj = enfermagemService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
