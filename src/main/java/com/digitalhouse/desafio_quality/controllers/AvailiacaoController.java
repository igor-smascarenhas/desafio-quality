package com.digitalhouse.desafio_quality.controllers;

import com.digitalhouse.desafio_quality.dtos.BairroDTO;
import com.digitalhouse.desafio_quality.dtos.CasaDTO;
import com.digitalhouse.desafio_quality.entities.Casa;
import com.digitalhouse.desafio_quality.services.AvaliacaoService;
import com.digitalhouse.desafio_quality.services.BairroService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AvailiacaoController {

    private AvaliacaoService avaliacaoService;
    private BairroService bairroService;

    public AvailiacaoController(AvaliacaoService avaliacaoService, BairroService bairroService) {
        this.avaliacaoService = avaliacaoService;
        this.bairroService = bairroService;
    }

    @PostMapping("/metros-quadrados")
    public ResponseEntity<Double> calcularMetrosQuadrados(@Valid @RequestBody CasaDTO casa) {
        return ResponseEntity.ok().body(avaliacaoService.calcularMetrosQuadrados(casa));
    }

    @PostMapping("/metros-quadrados/valor")
    public ResponseEntity<Double> calcularValorMetrosQuadrados(@Valid @RequestBody CasaDTO casa) {
        try {
            BairroDTO bairroDTO = bairroService.findBairroByNome(casa.getBairro());
            return ResponseEntity.ok().body(avaliacaoService.valorDaCasa(casa, bairroDTO.getValor()));
        } catch (NotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/metros-quadrados/valor/detalhes")
    public ResponseEntity<CasaDTO> casaDetalhes(@Valid @RequestBody CasaDTO casa) {
        try {
            BairroDTO bairroDTO = bairroService.findBairroByNome(casa.getBairro());
            return ResponseEntity.ok().body(avaliacaoService.casaDetalhes(casa, bairroDTO.getValor()));
        } catch (NotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
