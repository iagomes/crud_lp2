package com.crud.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.crud.dao.ProdutoDAO;
import com.crud.model.Produto;

public class ProdutoController {
	int autoId = 0; 
    ProdutoDAO dao = new ProdutoDAO();
    TxtController txt = new TxtController();

    public void createProduto() throws IOException {
        Produto p = new Produto(++autoId);
        saveOrUpdate(p);
    }

    public boolean validaProduto(Produto p) {
        return ((p.getNome() != null) && (p.getDescricao() != null) && (p.getValor() > 0)
           && !(p.getDescricao().isEmpty()) && !(p.getNome().isEmpty()));
    }

    public void listaProdutos() {
        List<Produto> lista = dao.listaProdutos();

        if (!lista.isEmpty()) {
            System.out.println("|ID \t |NOME \t |DESCRIÇÃO \t |VALOR " +
               "\n==============================");

            for (Produto produto : lista) {
                System.out.println(produto.getId() + "\t" +
                  produto.getNome() + "\t" + produto.getDescricao() + "\t" + produto.getValor());
            }
        }
        else {
            System.out.println("Não existem produtos cadastrados");
        }
    }

    public void prepareDelete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do produto que deseja excluir: ");
        Produto p = dao.getProduto(scanner.nextInt());

        if (p != null) {
            dao.deletaProduto(p);
        }
        else {
           System.out.println("Produto inexistente.");
        }
    }

    public void prepareUpdate() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do Produto que deseja alterar: ");
        Produto p = dao.getProduto(scanner.nextInt());

        if (p != null) {
            saveOrUpdate(p);
        }
        else {
            System.out.println("Produto inexistente");
        }
    }

    public void saveOrUpdate(Produto p) throws IOException {
        String itm = null;
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
       if (nome != null && !nome.isEmpty()) {
           p.setNome(nome);
           itm += nome + " / ";
       }

       System.out.println("Descrição: ");
       String descricao = scanner.nextLine();
       if (descricao != null && !descricao.isEmpty()) {
           p.setDescricao(descricao);
           itm += descricao + " / ";
       }

       System.out.println("Valor: ");
       double valor = scanner.nextDouble();
       if (valor > 0) {
           p.setValor(valor);
           itm += Double.toString(valor);
       }

       if (validaProduto(p)) {
           dao.saveOrUpdateProduto(p);
       }
       else {
           System.out.println("Nome, Descrição e Valor são obrigatorios!");
           p = null;
          --autoId;
       }
       txt.gravaProduto(itm);
    }
}

