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

import com.hospital.mmgservices.domain.Leito;
import com.hospital.mmgservices.dto.LeitoDTO;
import com.hospital.mmgservices.services.LeitoService;

@RestController
@RequestMapping(value="/leitos")
public class LeitoResource {
	
	@Autowired
	private LeitoService leitoservice;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Leito> find(@PathVariable Integer id) {
		Leito obj = leitoservice.find(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LeitoDTO>> findAll() {
		List<Leito> list = leitoservice.findAll();
		List<LeitoDTO> listDTO = list.stream().map(obj -> new LeitoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody LeitoDTO objDto){
		Leito obj = leitoservice.fromDTO(objDto);
		obj = leitoservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody LeitoDTO objDto, @PathVariable Integer id) {
		Leito obj = leitoservice.fromDTO(objDto);
		obj.setId(id);
		obj = leitoservice.update(obj);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		leitoservice.delete(id);
		return ResponseEntity.noContent().build();
	}
}
