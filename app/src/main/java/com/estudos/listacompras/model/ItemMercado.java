package com.estudos.listacompras.model;

public class ItemMercado {

    private long id;
    private String produto;
    private String preco;
    private int imagem;


    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getImagem() {
        return imagem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public ItemMercado(long id, String produto, String preco, int imagem){

        this.id = id;
        this.produto = produto;
        this.preco = preco;
        this.imagem = imagem;
    }
}
