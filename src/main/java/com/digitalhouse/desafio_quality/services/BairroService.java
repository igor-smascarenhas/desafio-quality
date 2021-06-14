package com.digitalhouse.desafio_quality.services;

import com.digitalhouse.desafio_quality.dtos.BairroDTO;
import com.digitalhouse.desafio_quality.entities.Bairro;
import com.digitalhouse.desafio_quality.repositories.BairroRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BairroService {

    BairroRepository bairroRepository;

    public BairroService(BairroRepository bairroRepository) {
        this.bairroRepository = bairroRepository;
    }

    public BairroDTO findBairroById(Long id) throws NotFoundException {
        Optional<Bairro> bairroOptional = bairroRepository.findById(id);

        if(!bairroOptional.isPresent()) {
            throw new NotFoundException("Bairro invalido");
        }

        return new BairroDTO(bairroOptional.get());

    }

    public BairroDTO findBairroByNome(String nome) throws NotFoundException {
        Optional<Bairro> bairroOptional = bairroRepository.findBairroByNome(nome);

        if(!bairroOptional.isPresent()) {
            throw new NotFoundException("AAAAAAA");
        }

        return new BairroDTO(bairroOptional.get());

    }

}
