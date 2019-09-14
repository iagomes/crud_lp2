package com.crud.dao;

import java.util.ArrayList;
import java.util.List;
import com.crud.model.Cliente;

public class ClienteDAO {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	 
    public List<Cliente> listaClientes() {
        return this.clientes;
    }

    public void deletaCliente(Cliente cliente) {
        clientes.remove(cliente);
        System.out.println("Apagando cadastro " + cliente.getId() + "...");
        cliente = null;
        System.out.println("Cadastro deletado");
    }

    public void saveOrUpdateCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            System.out.println("Cliente " + cliente.getId() + " atualizado com sucesso!");
        } else {
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        }
    }

    public Cliente getCliente(int id) {
        Cliente cliente = null;
        for (Cliente cl : clientes) {
         if (cl.getId() == id) {
              cliente = cl;
         }
        }
       return cliente;
    }
}
