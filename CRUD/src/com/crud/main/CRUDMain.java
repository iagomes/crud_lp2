package com.crud.main;

import java.io.IOException;
import java.util.Scanner;
import com.crud.dao.UsuarioDAO;

public class CRUDMain {

	static UsuarioDAO user = new UsuarioDAO();
	CRUDMenu crudMenu = new CRUDMenu();


	public static void validaLogin() {
		if(user.validaUser() == true) {
		}
	}
	
	public static void listaMetodos() {
		System.out.println("Escolha uma opção\n1 => Produto | 2 => Cliente | 3 => Pedido | 4 => Usuarios | 5 => Sair");
	}

	public void mainMenu(int opcoes) throws IOException {
		switch (opcoes) {
		case 1:
			crudMenu.menuProduto(0);
			break;
		case 2:
			crudMenu.menuCliente(0);
			break;
		case 3:
			break;
		case 4:
			crudMenu.menuUsuario(0);
			break;
		case 5:
			System.exit(0);
		default:
			System.out.println("Opção inválida\n");
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		
		validaLogin();
		
		CRUDMain crudMain = new CRUDMain();
		Scanner sc = new Scanner(System.in);
		int opcao;

		while (1 > 0) {
			crudMain.listaMetodos();
			opcao = sc.nextInt();
			crudMain.mainMenu(opcao);
		}
	}

}
