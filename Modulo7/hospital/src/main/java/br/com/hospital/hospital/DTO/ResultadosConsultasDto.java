package br.com.hospital.hospital.DTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class ResultadosConsultasDto implements Serializable {
    @NotNull
    private final String nome;

    private final Integer quantidade;

    public ResultadosConsultasDto(String nome, Integer quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultadosConsultasDto)) return false;
        ResultadosConsultasDto that = (ResultadosConsultasDto) o;
        return getNome().equals(that.getNome()) && getQuantidade().equals(that.getQuantidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getQuantidade());
    }

    @Override
    public String toString() {
        return "ResultadosConsultasDto{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
