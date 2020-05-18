package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.ExpecialidadeMedico;
@Repository
public interface ExpecialidadeMedicoRepository extends JpaRepository<ExpecialidadeMedico, Integer>{

}
