package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mmgservices.domain.Leito;

@Repository
public interface LeitoRepository extends JpaRepository<Leito, Integer> {

}
