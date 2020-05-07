package com.hospital.mmgservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mmgservices.domain.Cidade;
import com.hospital.mmgservices.repository.CidadeRepository;



@Service
public class CidadeService {
     
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findAll(){
		return cidadeRepository.findAll();
	} 
}
