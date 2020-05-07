package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Alergia;

@Repository
public interface AlergiaRepository extends JpaRepository<Alergia, Integer> {

}
