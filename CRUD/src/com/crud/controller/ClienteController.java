package com.crud.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.crud.dao.ClienteDAO;
import com.crud.model.Cliente;

public class ClienteController {
	int autoId = 0; 
    ClienteDAO dao = new ClienteDAO();
    TxtController txt = new TxtController();

    public void createCliente() throws IOException {
        Cliente c = new Cliente(++autoId);
        saveOrUpdate(c);
    }
    
    public boolean validaCliente(Cliente c) {
        return ((c.getNome() != null) && (c.getCnpj() != null))
           && !(c.getNome().isEmpty()) && !(c.getCnpj().isEmpty());
    }
    
    public void listaClientes() {
        List<Cliente> lista = dao.listaClientes();

        if (!lista.isEmpty()) {
            System.out.println("|ID \t |NOME \t |CNPJ " +
               "\n==============================");

            for (Cliente cliente : lista) {
                System.out.println(cliente.getId() + "\t" +
                  cliente.getNome() + "\t" + cliente.getCnpj());
            }
        }
        else {
            System.out.println("Não existem clientes cadastrados");
        }
    }
    
    public void prepareDelete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do cliente que deseja excluir: ");
        Cliente c = dao.getCliente(scanner.nextInt());

        if (c != null) {
            dao.deletaCliente(c);
        }
        else {
           System.out.println("Cliente inexistente.");
        }
    }
    
    public void prepareUpdate() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do Cliente que deseja alterar: ");
        Cliente c = dao.getCliente(scanner.nextInt());

        if (c != null) {
            saveOrUpdate(c);
        }
        else {
            System.out.println("Cliente inexistente");
        }
    }
    
    public void saveOrUpdate(Cliente c) throws IOException {
        String cli = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
       if (nome != null && !nome.isEmpty()) {
           c.setNome(nome);
           cli = nome + " / ";
       }

       System.out.println("Descrição: ");
       String cnpj = scanner.nextLine();
       if (cnpj != null && !cnpj.isEmpty()) {
           c.setCnpj(cnpj);
           cli += cnpj;
       }
       
       if (validaCliente(c)) {
           dao.saveOrUpdateCliente(c);
       }
       else {
           System.out.println("Nome e CNPJ são obrigatorios!");
           c = null;
          --autoId;
       }
       txt.gravaItem(cli);
    }
}
