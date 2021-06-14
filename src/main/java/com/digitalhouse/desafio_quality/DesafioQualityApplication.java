package com.digitalhouse.desafio_quality;

import com.digitalhouse.desafio_quality.entities.Bairro;
import com.digitalhouse.desafio_quality.repositories.BairroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DesafioQualityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesafioQualityApplication.class, args);
    }

    BairroRepository bairroRepository;

    public DesafioQualityApplication(BairroRepository bairroRepository) {
        this.bairroRepository = bairroRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Bairro b1 = new Bairro("AAAAAAA", 100.0);
        Bairro b2 = new Bairro("BBBBBBB", 120.0);
        Bairro b3 = new Bairro("CCCCCCC", 150.0);

        bairroRepository.saveAll(Arrays.asList(b1, b2, b3));
    }
}
