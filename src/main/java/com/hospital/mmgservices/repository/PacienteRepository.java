package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
