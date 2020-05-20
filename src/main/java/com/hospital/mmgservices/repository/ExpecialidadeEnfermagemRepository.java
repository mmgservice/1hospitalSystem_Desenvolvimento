package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.ExpecialidadeEnfermagem;

@Repository
public interface ExpecialidadeEnfermagemRepository extends JpaRepository<ExpecialidadeEnfermagem, Integer> {
     
}
