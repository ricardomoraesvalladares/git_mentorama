package br.com.ricardo.modulo1;

public class Aluno {
    private Integer id;
    private String nome;
    private Integer idade;


    public Aluno(int aluno, String nome, Integer idade) {
        this.id = aluno;
        this.nome = nome;
        this.idade = idade;
    }

    public Aluno(){}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
