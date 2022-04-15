package br.com.ricardo.modulo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlunoService {

    List<Aluno> alunos;

    public AlunoService() {
        Aluno a1 = new Aluno(1, "Maria da Silva", 13);
        Aluno a2 = new Aluno(2, "Joao Ribeiro", 9);
        Aluno a3 = new Aluno(3, "Rafael Coutinho", 11);
        Aluno a4 = new Aluno(4, "Sonia da Silva", 10);
        Aluno a5 = new Aluno(5, "Maria Clara", 9);

        this.alunos = new ArrayList<>(){{
            add(a1); add(a2); add(a3); add(a4); add(a5);
        }};
    }

    public List<Aluno> buscarTodosAlunos(){
        return alunos;
    }

    public List<Aluno> buscaAlunoPorNome(String nome) throws AlunoNaoEncontradoException {
       List<Aluno> alunosFiltrados = alunos.stream().
               filter(aluno -> aluno.getNome().contains(nome)).collect(Collectors.toList());
       if(alunosFiltrados.isEmpty()){
           throw new AlunoNaoEncontradoException(nome);
       }
       return alunosFiltrados;
    }

    public List<Aluno> buscaAlunoPorIdade(Integer idade){
        return alunos.stream().
                filter(aluno -> aluno.getIdade().equals(idade)).
                collect(Collectors.toList());
    }

    public Aluno buscaAlunoPorId(int id) throws AlunoNaoEncontradoException {
        return alunos.stream().filter(a -> a.getId().equals(id)).
                findFirst().orElseThrow(AlunoNaoEncontradoException::new);
    }

    public void adicionaAluno(Aluno novoAluno){
        alunos.add(novoAluno);
    }

    public void removeAluno(int id){
        alunos.removeIf(aluno -> aluno.getId().equals(id));
    }
}
