package br.com.ricardo.produto.produto.services;

import br.com.ricardo.produto.produto.model.Venda;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;


@Service
public class VendaService {

    public Double verificaDescontoMaiorQuePermitidoRetornaValor(@NotNull Venda venda){
        return (venda.getDesconto() <= venda.getProduto().getDescontoMaxPermitido()) ?
                venda.getDesconto() : venda.getProduto().getDescontoMaxPermitido();
    }

    public Integer verificaQuantidadeMaiorQueEstoqueRetornaValor(@NotNull Venda venda){
        return (venda.getQuantidade() <= venda.getProduto().getQuantidadeEmEstoque() ?
                venda.getQuantidade() : venda.getProduto().getQuantidadeEmEstoque());
    }

    public Double calculaValorTotalVenda(Venda venda){
        Double valorDesconto = verificaDescontoMaiorQuePermitidoRetornaValor(venda);
        Integer quantidade = verificaQuantidadeMaiorQueEstoqueRetornaValor(venda);
        return (quantidade * venda.getProduto().getValor()) - CalculaPorcentagem(venda, valorDesconto, quantidade);
    }

    private double CalculaPorcentagem(Venda venda, Double valorDesconto, Integer quantidade) {
        return (quantidade * venda.getProduto().getValor()) * valorDesconto;
    }

}
