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

import com.hospital.mmgservices.domain.NomeExame;
import com.hospital.mmgservices.dto.NomeExameDTO;
import com.hospital.mmgservices.services.NomeExameService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/nomeexames")
public class NomeExameResource {

	@Autowired
	private NomeExameService nomeExameService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<NomeExame> find(@PathVariable Integer id) throws ObjectNotFoundException {
		NomeExame obj = nomeExameService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<NomeExameDTO>> findAll() {
		List<NomeExame> list = nomeExameService.findAll();
		List<NomeExameDTO> listDto = list.stream().map(obj -> new NomeExameDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody NomeExameDTO objDto) throws ObjectNotFoundException {
		NomeExame obj = nomeExameService.fromDTO(objDto);
		obj = nomeExameService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody NomeExameDTO objDto, @PathVariable Integer id)
			throws ObjectNotFoundException {
		NomeExame obj = nomeExameService.fromDTO(objDto);
		obj.setId(id);
		obj = nomeExameService.upate(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException {
		nomeExameService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
