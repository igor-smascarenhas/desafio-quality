package com.digitalhouse.desafio_quality.repositories;

import com.digitalhouse.desafio_quality.entities.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRespository extends JpaRepository<Casa, Long> {
}
