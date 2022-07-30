package br.com.hospital.hospital.DTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PacienteDto implements Serializable {
    private final Long id;
    @NotNull
    private final String nome;
    private final String telefone;
    private final Date dataNascimento;

    public PacienteDto(Long id, String nome, String telefone, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteDto entity = (PacienteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.telefone, entity.telefone) &&
                Objects.equals(this.dataNascimento, entity.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, telefone, dataNascimento);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "telefone = " + telefone + ", " +
                "dataNascimento = " + dataNascimento + ")";
    }
}
