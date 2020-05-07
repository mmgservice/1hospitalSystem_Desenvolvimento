package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Residencia;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia, Integer> {

}
