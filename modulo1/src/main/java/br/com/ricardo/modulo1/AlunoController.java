package br.com.ricardo.modulo1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    Aluno a1 = new Aluno(1, "Maria da Silva", 13);
    Aluno a2 = new Aluno(2, "Joao Ribeiro", 9);
    Aluno a3 = new Aluno(3, "Rafael Coutinho", 11);
    Aluno a4 = new Aluno(4, "Sonia da Silva", 10);
    Aluno a5 = new Aluno(5, "Maria Clara", 9);

    List<Aluno> alunos = new ArrayList<>(){{
        add(a1); add(a2); add(a3); add(a4); add(a5);
    }};

    //Listar todos alunos
    @GetMapping
    public ResponseEntity<List<Aluno>> listaAlunos(){
        return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
    }

    //Listar alunos filtrando por nome
    @GetMapping(value = "/{nome}")
    public ResponseEntity<List<Aluno>> buscaAlunoNome(@PathVariable("nome") String nome){

        List<Aluno> alunosSelecionados = alunos.stream().
                filter(aluno -> aluno.getNome().contains(nome)).
                collect(Collectors.toList());

        if(!alunosSelecionados.isEmpty()){
            return new ResponseEntity<List<Aluno>> (alunosSelecionados, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<List<Aluno>>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
    }

    //Listar alunos filtrando por idade
    @GetMapping(value = "/idade/{idade}")
    public ResponseEntity<List<Aluno>> buscaAlunoIdade(@PathVariable("idade") Integer idade){

        List<Aluno> alunosSelecionados = alunos.stream().
                filter(aluno -> aluno.getIdade().equals(idade)).
                collect(Collectors.toList());

        if(!alunosSelecionados.isEmpty()){
            return new ResponseEntity<List<Aluno>>(alunosSelecionados, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<List<Aluno>>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
    }

    //Buscar aluno por ID
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Aluno> buscaAlunoPorId(@PathVariable("id") int id){

        Aluno alunoSelecionado = alunos.stream().filter(a -> a.getId().equals(id)).
                findFirst().orElse(null);

        if(alunoSelecionado != null){
            return new ResponseEntity<>(alunoSelecionado, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(alunoSelecionado, HttpStatus.NO_CONTENT);
        }
    }

    //Cadastrar novo aluno
    @PostMapping
    public ResponseEntity<Aluno> adicionaAluno(@RequestBody Aluno novoAluno){
        if(novoAluno.getId() == null){
            novoAluno.setId(alunos.size() + 1);
        }
        alunos.add(novoAluno);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    //Atualizar aluno
    @PutMapping
    public ResponseEntity<Aluno> atualizaAluno(@RequestBody Aluno aluno){
        Aluno alunoatualizar = alunos.stream().
                filter(a -> a.getId().equals(aluno.getId())).findFirst().get();
        alunoatualizar.setIdade(aluno.getIdade());
        alunoatualizar.setNome(aluno.getNome());

        return new ResponseEntity<>(alunoatualizar, HttpStatus.OK);
    }

    //Deletar aluno
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletaAluno(@PathVariable("id") int id){

        alunos.removeIf(aluno -> aluno.getId().equals(id));
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
