package com.digitalhouse.desafio_quality.avaliacao;

import com.digitalhouse.desafio_quality.dtos.CasaDTO;
import com.digitalhouse.desafio_quality.dtos.ComodoDTO;
import com.digitalhouse.desafio_quality.services.AvaliacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;


public class AvaliacaoServiceTest {

    private AvaliacaoService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AvaliacaoService();
    }

    @Test
    void canGetTotalArea() {
        // Given
        CasaDTO casaDTO = new CasaDTO();

        ComodoDTO c1 = new ComodoDTO();
        c1.setComprimento(10.0);
        c1.setLargura(10.0);

        ComodoDTO c2 = new ComodoDTO();
        c2.setComprimento(10.0);
        c2.setLargura(10.0);

        casaDTO.setComodos(Arrays.asList(c1, c2));

        // When
        Double actual = underTest.calcularMetrosQuadrados(casaDTO);

        // Then
        Double expected = 200.0;

        assertEquals(expected, actual);
    }

    @Test
    void canGetMaiorComodo () {
        // Given
        CasaDTO casaDTO = new CasaDTO();

        ComodoDTO c1 = new ComodoDTO();
        c1.setNome("Maior");
        c1.setComprimento(12.0);
        c1.setLargura(12.0);

        ComodoDTO c2 = new ComodoDTO();
        c2.setNome("Menor");
        c2.setComprimento(10.0);
        c2.setLargura(10.0);

        casaDTO.setComodos(Arrays.asList(c1, c2));

        // When
        String actual = underTest.getMaiorComodo(casaDTO.getComodos()).getNome();

        // Then
        String expected = "Maior";

        assertEquals(expected, actual);
    }

    @Test
    void canGetMetrosQuadradosComodo () {
        // Given
        ComodoDTO c1 = new ComodoDTO();
        c1.setNome("Maior");
        c1.setComprimento(12.0);
        c1.setLargura(12.0);


        // When
        Double actual = c1.getMetrosQuadrados();

        // Then
        Double expected = 144.0;

        assertEquals(expected, actual);
    }

}
