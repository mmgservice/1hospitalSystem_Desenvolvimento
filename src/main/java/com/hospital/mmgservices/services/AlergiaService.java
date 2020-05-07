package com.hospital.mmgservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Alergia;
import com.hospital.mmgservices.repository.AlergiaRepository;



@Service
public class AlergiaService {
     
	@Autowired
	private AlergiaRepository alergiaRepository;
	
	public List<Alergia> findAll(){
		return alergiaRepository.findAll();
	} 
}
