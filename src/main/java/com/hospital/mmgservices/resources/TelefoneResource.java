package com.hospital.mmgservices.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.mmgservices.domain.Telefone;
import com.hospital.mmgservices.services.TelefoneService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/telefones")
public class TelefoneResource {

	@Autowired
	private TelefoneService telefoneService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Telefone> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Telefone obj = telefoneService.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
