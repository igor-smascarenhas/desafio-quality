package com.digitalhouse.desafio_quality.repositories;

import com.digitalhouse.desafio_quality.entities.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

    Optional<Bairro> findBairroByNome(String nome);

}
