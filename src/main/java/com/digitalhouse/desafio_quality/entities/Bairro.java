package com.digitalhouse.desafio_quality.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do bairro não pode estar vazio.")
    @Size(min = 5, max = 45, message = "Nome do bairro deve conter no mínimo 8 caracteres e no máximo 50 caracteres")
    @Pattern(regexp = "^[A-z ]+$", message = "O nome do bairro deve começar com uma letra maiúscula.")
    private String nome;
    private Double valor;

    public Bairro() {
    }

    public Bairro(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
