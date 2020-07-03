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

import com.hospital.mmgservices.domain.Prescricao;
import com.hospital.mmgservices.dto.PrescricaoDTO;
import com.hospital.mmgservices.services.PrescricaoService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/prescricao")
public class PrescricaoResource {

	@Autowired
	private PrescricaoService prescricaoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PrescricaoDTO>> findAll() {
		List<Prescricao> list = prescricaoService.findAll();
		List<PrescricaoDTO> listDTO = list.stream().map(obj -> new PrescricaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Prescricao> find(@PathVariable Integer id) {
		Prescricao obj = prescricaoService.find(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PrescricaoDTO objDto) {
		Prescricao obj = prescricaoService.fromDTO(objDto);
		obj = prescricaoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PrescricaoDTO objDto, @PathVariable Integer id) {
		Prescricao obj = prescricaoService.fromDTO(objDto);
		obj.setId(id);
		obj = prescricaoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		prescricaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
