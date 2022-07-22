package br.com.hospital.hospital.DTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class ProfissionalDto implements Serializable {
    private final Long matricula;
    @NotNull
    private final String nome;
    private final String departamento;
    private final String cargo;
    private final String telefone;

    public ProfissionalDto(Long matricula, String nome, String departamento, String cargo, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
        this.cargo = cargo;
        this.telefone = telefone;
    }

    public Long getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfissionalDto entity = (ProfissionalDto) o;
        return Objects.equals(this.matricula, entity.matricula) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.departamento, entity.departamento) &&
                Objects.equals(this.cargo, entity.cargo) &&
                Objects.equals(this.telefone, entity.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, nome, departamento, cargo, telefone);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "matricula = " + matricula + ", " +
                "nome = " + nome + ", " +
                "departamento = " + departamento + ", " +
                "cargo = " + cargo + ", " +
                "telefone = " + telefone + ")";
    }
}
