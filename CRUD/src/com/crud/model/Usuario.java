package com.crud.model;

public class Usuario {
	private int id;
	private String login;
	private String senha;
	
    public Usuario(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String user) {
        this.login = user;
    }
    public String getSenha() {
        return senha;
    }
    public void setCnpj(String pw) {
        this.senha = pw;
    }
}
