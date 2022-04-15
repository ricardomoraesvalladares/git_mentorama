package br.com.ricardo.modulo1;

import java.util.function.Supplier;

public class AlunoNaoEncontradoException extends Exception{

    public AlunoNaoEncontradoException(String nome) {
        super("Aluno: " + nome + " não encontrado!!!");
    }

    public AlunoNaoEncontradoException() {
        super("Nenhum aluno encontrdo com Id informado !!!");
    }
}
