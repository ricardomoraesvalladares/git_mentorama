package br.com.ricardo.produto.produto.services;

import br.com.ricardo.produto.produto.model.Produto;
import br.com.ricardo.produto.produto.model.Venda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VendaServiceTest {

    private VendaService vendaService;
    private Produto produto;

    @BeforeEach
    void setUp() {
        this.vendaService = new VendaService();
        this.produto = new Produto(1L,"TV", 1000.00,10, 0.10);
    }

    @Test
    public void QuandoDescontoMaiorQuePermitidoDeveRetornarDescontoMaximoPermitido(){
        Venda venda = new Venda(produto, 2, 0.10);
        Double resultado = vendaService.verificaDescontoMaiorQuePermitidoRetornaValor(venda);
        Assertions.assertEquals(0.10,resultado);
    }

    @Test
    public void QuandoDescontoMenorIgualQuePermitidoDeveRetornarDescontoInformado(){
        Venda venda = new Venda(produto, 2, 0.10);
        Double resultado = vendaService.verificaDescontoMaiorQuePermitidoRetornaValor(venda);
        Assertions.assertEquals(0.10,resultado);
    }

    @Test
    public void QuandoQuantidadeMaiorQueEstoqueRetornarQuantidadeEmEstoque(){
        Venda venda = new Venda(produto, 11, 0.10);
        Integer resultado = vendaService.verificaQuantidadeMaiorQueEstoqueRetornaValor(venda);
        Assertions.assertEquals(10,resultado);
    }

    @Test
    public void QuandoQuantidadeMenorIgualQueEstoqueRetornarQuantidadeInformada(){
        Venda venda = new Venda(produto, 2, 0.15);
        Integer resultado = vendaService.verificaQuantidadeMaiorQueEstoqueRetornaValor(venda);
        Assertions.assertEquals(2,resultado);
    }

    @Test
    public void DeveCaularValorTotalVenda(){
        Venda venda = new Venda(produto, 2, 0.15);
        Double resultado = vendaService.calculaValorTotalVenda(venda);
        Assertions.assertEquals(1800, resultado);
    }

}
