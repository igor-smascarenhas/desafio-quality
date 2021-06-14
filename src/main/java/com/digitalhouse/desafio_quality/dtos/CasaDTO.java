package com.digitalhouse.desafio_quality.dtos;

import com.digitalhouse.desafio_quality.entities.Casa;
import com.digitalhouse.desafio_quality.entities.Comodo;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class CasaDTO {

    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Size(min = 5, max = 30, message = "Nome da propriedade deve conter no mínimo 5 caracteres, máximo 30 caracteres")
    @Pattern(regexp = "^[A-z ]+$", message = "Atenção, digite somente letras")
    @Pattern(regexp = "^([A-Z])[A-z ]+$", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String nome;

    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(min = 5, max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    @Pattern(regexp = "^[A-z ]+$", message = "Atenção, digite somente letras")
    private String bairro;

    private String endereco;

    @Valid
    private List<ComodoDTO> comodos;
    private double valorTotal;
    private Comodo maiorComodo;

    public CasaDTO() {
    }

    public CasaDTO(Casa casa) {
        this.nome = casa.getNome();
        this.bairro = casa.getBairro();
        this.endereco = casa.getEndereco();
        this.comodos = casa.getComodos().stream().map(comodo -> new ComodoDTO(comodo)).collect(Collectors.toList());
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

    public List<ComodoDTO> getComodos() {
        return comodos;
    }

    public void setComodos(List<ComodoDTO> comodos) {
        this.comodos = comodos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getMetrosQuadrados() {

        var total = 0.0;

        for(int i = 0; i<comodos.size(); i++) {
            total += comodos.get(i).getMetrosQuadrados();
        }

        return total;

    }

    public ComodoDTO getMaiorComodo() {
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setMaiorComodo(Comodo maiorComodo) {
        this.maiorComodo = maiorComodo;
    }
}

