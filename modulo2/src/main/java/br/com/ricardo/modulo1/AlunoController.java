package br.com.ricardo.modulo1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService = new AlunoService();

    //Listar todos alunos
    @GetMapping
    public ResponseEntity<List<Aluno>> listaAlunos(){

        return new ResponseEntity<List<Aluno>>(alunoService.buscarTodosAlunos(), HttpStatus.OK);
    }

    //Listar alunos filtrando por nome
    @GetMapping(value = "/{nome}")
    public ResponseEntity<List<Aluno>> buscaAlunoNome(@PathVariable("nome") String nome) throws AlunoNaoEncontradoException {

        try{
            List<Aluno> alunosSelecionados = alunoService.buscaAlunoPorNome(nome);
            return new ResponseEntity<List<Aluno>> (alunosSelecionados, HttpStatus.OK);
        }catch(AlunoNaoEncontradoException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<List<Aluno>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
    }

    //Listar alunos filtrando por idade
    @GetMapping(value = "/idade/{idade}")
    public ResponseEntity<List<Aluno>> buscaAlunoIdade(@PathVariable("idade") Integer idade){

        List<Aluno> alunosSelecionados = alunoService.buscaAlunoPorIdade(idade);

        if(!alunosSelecionados.isEmpty()){
            return new ResponseEntity<List<Aluno>>(alunosSelecionados, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<List<Aluno>>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
    }

    //Buscar aluno por ID
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Aluno> buscaAlunoPorId(@PathVariable("id") int id) throws AlunoNaoEncontradoException {

        try{
            Aluno alunoSelecionado = alunoService.buscaAlunoPorId(id);
            return new ResponseEntity<>(alunoSelecionado, HttpStatus.OK);
        }catch (AlunoNaoEncontradoException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //Cadastrar novo aluno
    @PostMapping
    public ResponseEntity<Aluno> adicionaAluno(@RequestBody Aluno novoAluno){
        if(novoAluno.getId() == null){
            novoAluno.setId(alunoService.buscarTodosAlunos().size() + 1);
        }
        alunoService.adicionaAluno(novoAluno);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    //Atualizar aluno
    @PutMapping
    public ResponseEntity<Aluno> atualizaAluno(@RequestBody Aluno aluno){
        try{
            Aluno alunoatualizar = alunoService.buscaAlunoPorId(aluno.getId());
            alunoatualizar.setIdade(aluno.getIdade());
            alunoatualizar.setNome(aluno.getNome());
            return new ResponseEntity<>(alunoatualizar, HttpStatus.OK);
        }catch (AlunoNaoEncontradoException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Deletar aluno
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletaAluno(@PathVariable("id") int id){
        alunoService.removeAluno(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
