package br.com.ricardo.Filme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.util.List;


public class Usuario {

   @Id
   private Long id;
   private String nome;

    public Usuario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Usuario (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
