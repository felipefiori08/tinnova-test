package com.cars.entity;

import java.time.LocalDateTime;

public class Veiculo {
    public Veiculo() {}

    public Veiculo(int id){
        this.id = id;
    }

    private int id;
    private String veiculo;
    private String marca;
    private int ano;
    private String descricao;
    private boolean vendido;
    private LocalDateTime created;
    private LocalDateTime updated;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isVendido() {
        return this.vendido;
    }

    public boolean getVendido() {
        return this.vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return this.updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

}
