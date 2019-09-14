package com.crud.model;

public class Cliente {
	private int id;
	private String nome;
	private String cnpj;
	
    public Cliente(int id) {
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
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
