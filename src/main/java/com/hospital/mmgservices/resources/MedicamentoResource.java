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

import com.hospital.mmgservices.domain.Medicamento;
import com.hospital.mmgservices.dto.MedicamentoDTO;
import com.hospital.mmgservices.services.MedicamentoService;

@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentoResource {

	@Autowired
	private MedicamentoService medicamentoservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MedicamentoDTO>> findAll() {
		List<Medicamento> list = medicamentoservice.findAll();
		List<MedicamentoDTO> listDTO = list.stream().map(obj -> new MedicamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MedicamentoDTO objDto) {
		Medicamento obj = medicamentoservice.fromDTO(objDto);
		obj = medicamentoservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
