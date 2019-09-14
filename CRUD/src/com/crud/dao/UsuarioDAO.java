package com.crud.dao;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

import com.crud.model.Cliente;
import com.crud.model.Usuario;

public class UsuarioDAO {

	public boolean validaUser() {
		boolean teste = false;
		try {
			while (teste == false) {
				BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));

				String arquivo = "dataUser.txt";
				System.out.println("Login: ");
				String usuario = ler.readLine();
				System.out.println("Senha: ");
				String senha = ler.readLine();

				if (confere(usuario, senha, new File(arquivo))) {
					teste = true;
					break;
				}
				System.out.println("Usuário / Senha incorretos!");
			}
			return teste;
		} catch (Throwable t) {
			t.printStackTrace();
			return false;
		}
	}

	public static boolean confere(String usuario, String senha, File arquivo) throws IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(arquivo));
		String usuarioLido = p.getProperty("usuario");
		String senhaLida = p.getProperty("senha");
		return usuario.equals(usuarioLido) && senha.equals(senhaLida);
	}
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	 
    public List<Usuario> listaUsuarios() {
        return this.usuarios;
    }

    public void deletaUsuario(Usuario user) {
        usuarios.remove(user);
        System.out.println("Apagando cadastro " + user.getId() + "...");
        user = null;
        System.out.println("Cadastro deletado");
    }

    public void saveOrUpdateUsuario(Usuario user) {
        if (usuarios.contains(user)) {
            System.out.println("Cliente " + user.getId() + " atualizado com sucesso!");
        } else {
            usuarios.add(user);
            System.out.println("Cliente cadastrado com sucesso!");
        }
    }

    public Usuario getUsuairio(int id) {
        Usuario user = null;
        for (Usuario u : usuarios) {
         if (u.getId() == id) {
              user = u;
         }
        }
       return user;
    }
}
