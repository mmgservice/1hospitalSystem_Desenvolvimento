package com.hospital.mmgservices.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
