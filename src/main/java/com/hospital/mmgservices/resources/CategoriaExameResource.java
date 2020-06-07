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
import com.hospital.mmgservices.domain.CategoriaExame;
import com.hospital.mmgservices.dto.CategoriaExameDTO;
import com.hospital.mmgservices.services.CategoriaExameService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categoriaexames")
public class CategoriaExameResource {

	@Autowired
	private CategoriaExameService categoriaExameService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaExame> find(@PathVariable Integer id) throws ObjectNotFoundException {
		CategoriaExame obj = categoriaExameService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaExameDTO>> findAll() {
		List<CategoriaExame> list = categoriaExameService.findAll();
		List<CategoriaExameDTO> listDto = list.stream().map(obj -> new CategoriaExameDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaExameDTO objDto) throws ObjectNotFoundException {
		CategoriaExame obj = categoriaExameService.fromDto(objDto);
		obj = categoriaExameService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody CategoriaExameDTO objDto, @PathVariable Integer id)
			throws ObjectNotFoundException {
		CategoriaExame obj = categoriaExameService.fromDto(objDto);
		obj.setId(id);
		obj = categoriaExameService.upate(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException {
		categoriaExameService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
