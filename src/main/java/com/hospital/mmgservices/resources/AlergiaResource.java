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

import com.hospital.mmgservices.domain.Alergia;
import com.hospital.mmgservices.dto.AlergiaDTO;
import com.hospital.mmgservices.services.AlergiaService;

@RestController
@RequestMapping(value = "/alergias")
public class AlergiaResource {

	@Autowired
	private AlergiaService alergiaService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AlergiaDTO>> findAll() {
		List<Alergia> list = alergiaService.findAll();
		List<AlergiaDTO> listDto = list.stream().map(obj -> new AlergiaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Alergia> find(@PathVariable Integer id) {
		Alergia obj = alergiaService.find(id);
		return ResponseEntity.ok().body(obj);
	}	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AlergiaDTO objDto) {
		Alergia obj = alergiaService.fromDTO(objDto);
		obj = alergiaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody AlergiaDTO objDto, @PathVariable Integer id) {
		Alergia obj = alergiaService.fromDTO(objDto);
		obj.setId(id);
		obj = alergiaService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		alergiaService.delete(id);
		return ResponseEntity.noContent().build();

	}
}
