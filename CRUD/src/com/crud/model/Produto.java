package com.crud.model;

public class Produto {
	private int id;
    private String nome;
    private String descricao;
    private double valor;

    public Produto(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValor() {
    	return valor;
    }
    public void setValor(double valor) {
    	this.valor = valor;
    }
}
