package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {

}
