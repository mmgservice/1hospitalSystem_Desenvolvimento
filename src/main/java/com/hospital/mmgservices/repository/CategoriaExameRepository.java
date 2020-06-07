package com.hospital.mmgservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hospital.mmgservices.domain.CategoriaExame;

@Repository
public interface CategoriaExameRepository extends JpaRepository<CategoriaExame, Integer> {

}
