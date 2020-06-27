package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Prescricao;

@Repository
public interface PrescricaoRepository extends JpaRepository<Prescricao, Integer>{

}
