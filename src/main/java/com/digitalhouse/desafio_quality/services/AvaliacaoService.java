package com.digitalhouse.desafio_quality.services;

import com.digitalhouse.desafio_quality.dtos.CasaDTO;
import com.digitalhouse.desafio_quality.dtos.ComodoDTO;
import com.digitalhouse.desafio_quality.entities.Casa;
import com.digitalhouse.desafio_quality.entities.Comodo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    public Double calcularMetrosQuadrados(CasaDTO casa) {
        return casa.getMetrosQuadrados();
    }

    public Double valorDaCasa(CasaDTO casa, Double precoMetroQuadrado) {
        return casa.getMetrosQuadrados() * precoMetroQuadrado;
    }

    public CasaDTO casaDetalhes(CasaDTO casa, Double precoMetroQuadrado) {

        casa.setValorTotal(valorDaCasa(casa, precoMetroQuadrado));

        return casa;
    }

    public ComodoDTO getMaiorComodo(List<ComodoDTO> comodos) {
        ComodoDTO maiorComodo = null;
        Double maiorValor = 0.0;

        for(int i = 0; i<comodos.size(); i++) {

            if(comodos.get(i).getMetrosQuadrados() > maiorValor) {
                maiorValor = comodos.get(i).getMetrosQuadrados();
                maiorComodo = comodos.get(i);
            }

        }

        return maiorComodo;

    }
}


