package com.digitalhouse.desafio_quality.bairro;

import com.digitalhouse.desafio_quality.repositories.BairroRepository;
import com.digitalhouse.desafio_quality.services.BairroService;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class BairroServiceTest {

    @Mock
    private BairroRepository bairroRepository;
    private BairroService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BairroService(bairroRepository);
    }


    @Test
    public void itShouldThrowNotFoundExceptionWhenBairroDoenstExists() {
        assertThrows(NotFoundException.class, ()->{
            underTest.findBairroByNome("AAAAAAA");
        });
    }

}
