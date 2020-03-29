package com.estudos.listacompras.model;

import java.io.Serializable;

public class ListaCompra implements Serializable {

    Long id;
    String nome;
    String data;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
