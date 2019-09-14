package com.crud.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.crud.dao.ClienteDAO;
import com.crud.dao.UsuarioDAO;
import com.crud.model.Cliente;
import com.crud.model.Usuario;

public class UserController {
	int autoId = 0; 
    UsuarioDAO dao = new UsuarioDAO();
    TxtController txt = new TxtController();

    public void createUsuario() throws IOException {
        Usuario usr = new Usuario(++autoId);
        saveOrUpdate(usr);
    }
    
    public boolean validaUsuario(Usuario usr) {
        return ((usr.getLogin() != null) && (usr.getSenha() != null))
           && !(usr.getLogin().isEmpty()) && !(usr.getSenha().isEmpty());
    }
    
    public void prepareDelete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do cliente que deseja excluir: ");
        Usuario u = dao.getUsuairio(scanner.nextInt());

        if (u != null) {
            dao.deletaUsuario(u);
        }
        else {
           System.out.println("Usuario inexistente.");
        }
    }
    
    public void prepareUpdate() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do Cliente que deseja alterar: ");
        Usuario u = dao.getUsuairio(scanner.nextInt());

        if (u != null) {
            saveOrUpdate(u);
        }
        else {
            System.out.println("usuario inexistente");
        }
    }
    
    public void saveOrUpdate(Usuario u) throws IOException {
        String usr = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
       if (nome != null && !nome.isEmpty()) {
           u.setLogin(nome);
           usr = nome + "=";
       }

       System.out.println("Descrição: ");
       String senha = scanner.nextLine();
       if (senha != null && !senha.isEmpty()) {
           u.setCnpj(senha);
           usr += senha;
       }
       
       if (validaUsuario(u)) {
           dao.saveOrUpdateUsuario(u);
       }
       else {
           System.out.println("Login e senha são obrigatorios!");
           u = null;
          --autoId;
       }
       txt.gravaItem(usr);
    }
}
