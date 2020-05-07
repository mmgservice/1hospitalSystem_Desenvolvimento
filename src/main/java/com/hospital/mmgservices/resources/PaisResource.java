package com.hospital.mmgservices.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.mmgservices.domain.Pais;
import com.hospital.mmgservices.dto.PaisDTO;
import com.hospital.mmgservices.services.PaisService;

@RestController
@RequestMapping(value = "/pais")
public class PaisResource {

	@Autowired
	private PaisService paisService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PaisDTO>> findAll() {
		List<Pais> list = paisService.findAll();
		List<PaisDTO> listDto = list.stream().map(obj -> new PaisDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
