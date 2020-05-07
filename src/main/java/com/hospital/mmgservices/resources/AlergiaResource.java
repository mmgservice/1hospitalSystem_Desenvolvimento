package com.hospital.mmgservices.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
