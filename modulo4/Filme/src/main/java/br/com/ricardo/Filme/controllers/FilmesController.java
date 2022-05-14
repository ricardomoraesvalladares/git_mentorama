package br.com.ricardo.Filme.controllers;

import br.com.ricardo.Filme.entities.Filme;
import br.com.ricardo.Filme.repositories.IFilmesRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    IFilmesRepositories filmeRepositories;

    private static final Logger logger = LoggerFactory.getLogger(FilmesController.class);

    @GetMapping
    public ResponseEntity<List<Filme>> filmes(){
        if(filmeRepositories.listaFilmes().isEmpty()){
            logger.info("Lista de filmes vazia!!!");
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filmeRepositories.listaFilmes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addFilme(@RequestBody Filme filme){
        try{
            Filme novoFilme = new Filme(filme.getNome(), filme.getNomeDiretor(), filme.getAno(), filme.getNota());
            filmeRepositories.addFilme(novoFilme);
            return new ResponseEntity(HttpStatus.OK);
        }catch (RuntimeException e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeFilme(@PathVariable("id") long id){
        if(filmeRepositories.removeFilme(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            logger.error("Filme não encontrado!!!");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Filme> updateFilme(@RequestBody Filme filme){
        try{
            Filme filmeAtualizado = filmeRepositories.updateFilme(filme);
            return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}