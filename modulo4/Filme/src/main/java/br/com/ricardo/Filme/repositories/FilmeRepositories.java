package br.com.ricardo.Filme.repositories;

import br.com.ricardo.Filme.entities.Filme;
import br.com.ricardo.Filme.services.IFilmeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmeRepositories implements IFilmesRepositories {

    public static final List<Filme> filmes = new ArrayList<>();

    @Autowired
    IFilmeServices filmeServices;

    public List<Filme> listaFilmes(){
        return filmes;
    }

    public void addFilme(Filme filme){
        if(filmeServices.validaNota(filme.getNota())){
            if(filmeServices.verificaFilmeAntesDeAdicionar(filme)){
                filmes.add(filme);
            }else{
                throw new RuntimeException("Filme duplicado, não foi possível inserir!!!");
            }
        }else{
            throw new RuntimeException("Nota inválida!!!");
        }
    }

    public boolean removeFilme(long id){
       return filmes.removeIf(f -> f.getId().equals(id));
    }



    public Filme updateFilme(Filme filme){
        Filme filmeAtualizar = buscaFilmePorId(filme.getId());
        if (filmeServices.validaNota(filme.getNota()) && filmeAtualizar != null) {
                filmeAtualizar.setNome(filme.getNome());
                filmeAtualizar.setNota(filme.getNota());
                filmeAtualizar.setAno(filme.getAno());
                filmeAtualizar.setNomeDiretor(filme.getNomeDiretor());
                return filmeAtualizar;
            }else {
                throw new RuntimeException("Nota inválida ou filme não encontrado!!!");
            } 
    }

    public Filme buscaFilmePorId(Long id) {
        for(Filme filme : filmes){
            if(filme.getId().equals(id)){
                return filme;
            }
        }
        return null;
    }
}
