package br.com.ricardo.Filme.services;

import br.com.ricardo.Filme.entities.Filme;
import br.com.ricardo.Filme.repositories.FilmeRepositories;
import org.springframework.stereotype.Service;

@Service
public class FilmeServices implements IFilmeServices{

    //Valida se o filme já existe na coleção
    public boolean verificaFilmeAntesDeAdicionar(Filme filme){
        for(Filme f : FilmeRepositories.filmes){
            if(f.getNome().equals(filme.getNome()) && f.getAno() == filme.getAno()
                    && f.getNomeDiretor().equals(filme.getNomeDiretor())){
                return false;
            }
        }
        return true;
    }

    public boolean validaNota(int nota){
        if(nota > 0 && nota<= 5){
            return true;
        }
        else{
            return false;
        }
    }
}
