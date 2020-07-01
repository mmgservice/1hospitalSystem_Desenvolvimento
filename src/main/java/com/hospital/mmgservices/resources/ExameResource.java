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
import com.hospital.mmgservices.domain.Exame;
import com.hospital.mmgservices.dto.ExameDTO;
import com.hospital.mmgservices.services.ExameService;

@RestController
@RequestMapping(value = "/exames")
public class ExameResource {

	@Autowired
    private ExameService exameService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExameDTO>> findAll() {
		List<Exame> list = exameService.findAll();
		List<ExameDTO> listDTO = list.stream().map(obj -> new ExameDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ExameDTO objDto) {
		Exame obj = exameService.fromDTO(objDto);
		obj = exameService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Exame> find(@PathVariable Integer id) {
		Exame obj = exameService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ExameDTO objDto,
			@PathVariable Integer id) {
		Exame obj = exameService.fromDTO(objDto);
		obj.setId(id);
		obj = exameService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		exameService.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
