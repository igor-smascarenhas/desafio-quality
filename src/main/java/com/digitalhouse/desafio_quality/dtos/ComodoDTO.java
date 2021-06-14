package com.digitalhouse.desafio_quality.dtos;

import com.digitalhouse.desafio_quality.entities.Comodo;

import javax.validation.constraints.*;

public class ComodoDTO {

    private Long id;

    @NotBlank(message = "O campo não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    @Pattern(regexp = "^[A-z ]+$", message = "Atenção, digite somente letras")
    @Pattern(regexp = "^([A-Z])[A-z ]+$", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    private String nome;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    private Double largura;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    private Double comprimento;

    public ComodoDTO() {
    }

    public ComodoDTO(Comodo comodo) {
        this.id = comodo.getId();
        this.nome = comodo.getNome();
        this.largura = comodo.getLargura();
        this.comprimento = comodo.getComprimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getMetrosQuadrados() {
        return this.comprimento * this.largura;
    }

}
