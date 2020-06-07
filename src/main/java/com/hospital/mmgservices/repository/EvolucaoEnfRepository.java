package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.EvolucaoEnfermagem;

@Repository
public interface EvolucaoEnfRepository extends JpaRepository<EvolucaoEnfermagem, Integer>{

}
