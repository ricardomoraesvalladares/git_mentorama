package br.com.ricardo.produto.produto.controller;

import br.com.ricardo.produto.produto.model.Produto;
import br.com.ricardo.produto.produto.repositories.ProdutoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepositorie produtoRepositorie;

    @GetMapping
    public ResponseEntity<List<Produto>> listProducts(){
        List<Produto> produtos = produtoRepositorie.listaProdutos();
        if(produtos.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> addProduto(@RequestBody Produto produto){
        produtoRepositorie.addProduto(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

}
