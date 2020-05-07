package com.hospital.mmgservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Residencia;
import com.hospital.mmgservices.repository.ResidenciaRepository;



@Service
public class ResidenciaService {
     
	@Autowired
	private ResidenciaRepository residenciaRepository;
	
	public List<Residencia> findAll(){
		return residenciaRepository.findAll();
	} 
}
