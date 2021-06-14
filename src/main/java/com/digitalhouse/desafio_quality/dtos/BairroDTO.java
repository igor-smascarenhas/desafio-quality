package com.digitalhouse.desafio_quality.dtos;

import com.digitalhouse.desafio_quality.entities.Bairro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BairroDTO {

    @NotBlank(message = "O nome do bairro é obrigatório")
    @Size(min = 8, max = 50, message = "Nome do bairro deve conter no mínimo 5 caracteres e no máximo 14 caracteres")
    @Pattern(regexp = "^[A-z ]+$", message = "Atenção, digite somente letras")
    private String nome;
    private Double valor;

    public BairroDTO(Bairro bairro) {
        this.nome = bairro.getNome();
        this.valor = bairro.getValor();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
