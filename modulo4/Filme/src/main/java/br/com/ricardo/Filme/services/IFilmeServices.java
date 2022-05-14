package br.com.ricardo.Filme.services;

import br.com.ricardo.Filme.entities.Filme;
import br.com.ricardo.Filme.repositories.FilmeRepositories;

import org.springframework.stereotype.Service;


@Service
public interface IFilmeServices {

    //Assegura ID unico na criação de novo na construção novo Filme
    static Long atribuiId(){
        return (long) (FilmeRepositories.filmes.size() + 1);
    }

    boolean validaNota(int nota);

    boolean verificaFilmeAntesDeAdicionar(Filme filme);

}
