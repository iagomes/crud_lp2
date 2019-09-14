package com.crud.main;

import java.io.IOException;
import java.util.Scanner;
import com.crud.controller.ClienteController;
import com.crud.controller.ProdutoController;
import com.crud.controller.UserController;

public class CRUDMenu {

	Scanner sc = new Scanner(System.in);

	ProdutoController produto = new ProdutoController();
	ClienteController cliente = new ClienteController();
	UserController usuario = new UserController();

	public void menuProduto(int opcao) throws IOException {
		System.out.println("Escolha uma opção\n1 => Cadastrar Produto | 2 => Alterar Produto | 3 => Listar Produtos | "
				+ "4 => Excluir Produto");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			produto.createProduto();
			break;
		case 2:
			produto.prepareUpdate();
			break;
		case 3:
			produto.listaProdutos();
			break;
		case 4:
			produto.prepareDelete();
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
	}

	public void menuCliente(int opcao) throws IOException {
		System.out.println("Escolha uma opção\n1 => Cadastrar Cliente | 2 => Alterar Cliente | 3 => Listar Clientes | "
				+ "4 => Excluir Clientes");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			cliente.createCliente();
			break;
		case 2:
			cliente.prepareUpdate();
			break;
		case 3:
			cliente.listaClientes();
			break;
		case 4:
			produto.prepareDelete();
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
	}
	
	public void menuUsuario(int opcao) throws IOException {
		System.out.println("Escolha uma opção\n1 => Cadastrar Usuario | 2 => Alterar Usuario | 3 => Excluir Usuario");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			usuario.createUsuario();
			break;
		case 2:
			usuario.prepareUpdate();
			break;
		case 3:
			usuario.prepareDelete();
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
	}
}
