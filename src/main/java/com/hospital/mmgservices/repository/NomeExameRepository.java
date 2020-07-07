package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.NomeExame;

@Repository
public interface NomeExameRepository extends JpaRepository<NomeExame, Integer> {

}
