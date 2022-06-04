package br.com.ricardo.produto.produto.model;

public class Produto {

    private Long id;
    private String nome;
    private double valor;
    private int quantidadeEmEstoque;
    private double descontoMaxPermitido;

    public Produto(Long id, String nome, double valor, int quantidadeEmEstoque, double descontoMaxPermitido) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.descontoMaxPermitido = descontoMaxPermitido;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public double getDescontoMaxPermitido() {
        return descontoMaxPermitido;
    }

}
