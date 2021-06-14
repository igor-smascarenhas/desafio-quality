package com.digitalhouse.desafio_quality.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String bairro;

    private String nome;
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "casa")
    private List<Comodo> comodos;

    public Casa() {
    }

    public Casa(String bairro, String nome, String endereco) {
        this.bairro = bairro;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Double getMetrosQuadrados() {

        var total = 0.0;

        for(int i = 0; i<comodos.size(); i++) {
            total += comodos.get(i).getMetrosQuadrados();
        }

        return total;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }
}

