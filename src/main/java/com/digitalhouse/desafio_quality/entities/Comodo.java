package com.digitalhouse.desafio_quality.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Comodo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Double largura;
    private Double comprimento;

    @ManyToOne
    @JoinColumn(name = "casa_id", referencedColumnName = "id")
    private Casa casa;

    public Comodo() {
    }

    public Comodo(Long id, String nome, Double largura, Double comprimento, Casa casa) {
        this.id = id;
        this.nome = nome;
        this.largura = largura;
        this.comprimento = comprimento;
        this.casa = casa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMetrosQuadrados() {
        return this.comprimento * this.largura;
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

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
}
