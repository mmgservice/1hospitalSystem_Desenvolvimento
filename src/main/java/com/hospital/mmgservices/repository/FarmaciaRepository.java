package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Integer> {

}
