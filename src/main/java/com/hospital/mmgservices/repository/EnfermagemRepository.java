package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Enfermagem;

@Repository
public interface EnfermagemRepository extends JpaRepository<Enfermagem, Integer>{

}
