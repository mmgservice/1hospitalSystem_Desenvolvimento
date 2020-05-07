package com.hospital.mmgservices.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.mmgservices.domain.Residencia;
import com.hospital.mmgservices.dto.ResidenciaDTO;
import com.hospital.mmgservices.services.ResidenciaService;

@RestController
@RequestMapping(value = "/residencias")
public class ResidenciaResource {

	@Autowired
	private ResidenciaService residenciaService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ResidenciaDTO>> findAll() {
		List<Residencia> list = residenciaService.findAll();
		List<ResidenciaDTO> listDto = list.stream().map(obj -> new ResidenciaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
