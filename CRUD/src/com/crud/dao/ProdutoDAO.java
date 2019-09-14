package com.crud.dao;

import java.util.ArrayList;
import java.util.List;
import com.crud.model.Produto;

public class ProdutoDAO {
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	 
    public List<Produto> listaProdutos() {
        return this.produtos;
    }

    public void deletaProduto(Produto produto) {
        produtos.remove(produto);
        System.out.println("Deletando produto " + produto.getId() + "...");
        produto = null;
        System.out.println("Produto deletado");
    }

    public void saveOrUpdateProduto(Produto produto) {
        if (produtos.contains(produto)) {
            System.out.println("Produto " + produto.getId() + " atualizado com sucesso!");
        } else {
            produtos.add(produto);
            System.out.println("Produto cadastrado com sucesso!");
        }
    }

    public Produto getProduto(int id) {
        Produto produto = null;
        for (Produto prod : produtos) {
         if (prod.getId() == id) {
              produto = prod;
         }
        }
       return produto;
    }
}
