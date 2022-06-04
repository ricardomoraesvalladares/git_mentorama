package br.com.ricardo.produto.produto.controller;

import br.com.ricardo.produto.produto.model.Produto;
import br.com.ricardo.produto.produto.model.Venda;
import br.com.ricardo.produto.produto.repositories.ProdutoRepositorie;
import br.com.ricardo.produto.produto.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    ProdutoRepositorie produtoRepositorie;

    @Autowired
    VendaService vendaService;


    @GetMapping
    public ResponseEntity<Double> RealizaVenda(){
        Produto itemVenda = produtoRepositorie.listaProdutos().get(0);
        Venda venda = new Venda(itemVenda, 2, 0.10);
        double valorTotalVenda = vendaService.calculaValorTotalVenda(venda);
        return new ResponseEntity<>(valorTotalVenda, HttpStatus.OK);
    }


}
