package com.digitalhouse.desafio_quality.repositories;

import com.digitalhouse.desafio_quality.entities.Comodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComodoRepository extends JpaRepository<Comodo, Long> {
}
