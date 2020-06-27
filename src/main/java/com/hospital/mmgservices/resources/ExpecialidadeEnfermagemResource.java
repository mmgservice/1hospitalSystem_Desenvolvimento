package com.hospital.mmgservices.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hospital.mmgservices.domain.ExpecialidadeEnfermagem;
import com.hospital.mmgservices.dto.ExpecialidadeEnfermagemDTO;
import com.hospital.mmgservices.services.ExpecialidadeEnfermagemService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/expecialidadeenfermagem")
public class ExpecialidadeEnfermagemResource {

	@Autowired
	private ExpecialidadeEnfermagemService expecialidadeEnfermagemService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ExpecialidadeEnfermagem objDto) {
		ExpecialidadeEnfermagem obj = expecialidadeEnfermagemService.fromDTO(objDto);
		obj = expecialidadeEnfermagemService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExpecialidadeEnfermagemDTO>> findAll() {
		List<ExpecialidadeEnfermagem> list = expecialidadeEnfermagemService.findAll();
		List<ExpecialidadeEnfermagemDTO> listDTO = list.stream().map(obj -> new ExpecialidadeEnfermagemDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<ExpecialidadeEnfermagem> find(@PathVariable Integer id) {
		ExpecialidadeEnfermagem obj = expecialidadeEnfermagemService.find(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ExpecialidadeEnfermagemDTO objDto,
			@PathVariable Integer id) {
		ExpecialidadeEnfermagem obj = expecialidadeEnfermagemService.fromDTO(objDto);
		obj.setId(id);
		obj = expecialidadeEnfermagemService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		expecialidadeEnfermagemService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
