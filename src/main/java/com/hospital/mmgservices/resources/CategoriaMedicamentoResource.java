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

import com.hospital.mmgservices.domain.CategoriaMedicamento;
import com.hospital.mmgservices.dto.CategoriaMedicamentoDTO;
import com.hospital.mmgservices.services.CategoriaMedicamentoService;

@RestController
@CrossOrigin("*")
@RequestMapping(value= "/categoriamedicamentos")
public class CategoriaMedicamentoResource {

	@Autowired
	private CategoriaMedicamentoService categoriamedicamentoservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaMedicamentoDTO>> findAll(){
		List<CategoriaMedicamento> list = categoriamedicamentoservice.findAll();
		List<CategoriaMedicamentoDTO> listDTO = list.stream().map(obj -> new CategoriaMedicamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaMedicamento objDto) {
		CategoriaMedicamento obj = categoriamedicamentoservice.fromDTO(objDto);
		obj = categoriamedicamentoservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
