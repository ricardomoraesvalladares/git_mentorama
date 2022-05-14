package br.com.ricardo.Filme.repositories;

import br.com.ricardo.Filme.entities.Filme;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IFilmesRepositories {

    List<Filme> listaFilmes();
    void addFilme(Filme filme);
    boolean removeFilme(long id);
    Filme updateFilme(Filme filme);
    Filme buscaFilmePorId(Long id);
}
