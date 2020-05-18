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

import com.hospital.mmgservices.domain.Quarto;
import com.hospital.mmgservices.dto.QuartoDTO;
import com.hospital.mmgservices.services.QuartoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/quartos")
public class QuartoResouce {

	@Autowired
	private QuartoService quartoservice;
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Quarto> find(@PathVariable Integer id) throws ObjectNotFoundException{
		Quarto obj = quartoservice.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<QuartoDTO>> findAll() {
		List<Quarto> list = quartoservice.findAll();
		List<QuartoDTO> listDTO = list.stream().map(obj -> new QuartoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody QuartoDTO objDto) {
		Quarto obj = quartoservice.fromDTO(objDto);
		obj = quartoservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update (@Valid @RequestBody QuartoDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException{
		Quarto obj = quartoservice.fromDTO(objDto);
		obj.setId(id);
		obj = quartoservice.update(obj);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id) throws ObjectNotFoundException{
		quartoservice.delete(id);
		return ResponseEntity.noContent().build();
	}
}
