package br.com.ricardo.produto.produto.model;

public class Venda {

    private final Produto produto;
    private final int quantidade;
    private Double desconto;

    public Venda(Produto produto, int quantidade, Double desconto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public Produto getProduto() {
        return produto;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

}
