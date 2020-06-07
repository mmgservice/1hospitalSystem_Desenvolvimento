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

import com.hospital.mmgservices.domain.Paciente;
import com.hospital.mmgservices.dto.PacienteDTO;
import com.hospital.mmgservices.services.PacienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteService pacienteservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> findAll() {
		List<Paciente> list = pacienteservice.findAll();
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PacienteDTO objDto) throws ObjectNotFoundException {
		Paciente obj = pacienteservice.fromDTO(objDto);
		obj = pacienteservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
