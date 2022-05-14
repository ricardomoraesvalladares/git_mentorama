package br.com.ricardo.Filme.entities;

import br.com.ricardo.Filme.services.IFilmeServices;

public class Filme {
    private Long id;
    private String nome;
    private String nomeDiretor;
    private int ano;
    private int nota;

    public Filme(String nome, String nomeDiretor, int ano, int nota) {
        this.id = IFilmeServices.atribuiId();
        this.nome = nome;
        this.nomeDiretor = nomeDiretor;
        this.ano = ano;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
