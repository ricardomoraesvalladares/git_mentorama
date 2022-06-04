package br.com.ricardo.produto.produto.repositories;

import br.com.ricardo.produto.produto.model.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoRepositorie {

    private static final Produto p1 = new Produto((long) 1, "TV", 1000.00, 10, 0.10);
    private static final Produto p2 = new Produto((long) 2, "Notebook", 2000.00, 20, 0.15);
    private static final List<Produto> produtos = new ArrayList<>(){{add(p1); add(p2);}};

    public List<Produto> listaProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto){
        produtos.add(produto);
    }
}
