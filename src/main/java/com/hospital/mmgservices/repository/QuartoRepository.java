package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer>{

}
