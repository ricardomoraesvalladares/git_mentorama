package br.com.hospital.hospital.DTO;

import br.com.hospital.hospital.Entity.Internacao;
import br.com.hospital.hospital.Entity.Paciente;
import br.com.hospital.hospital.Entity.Profissional;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class InternacaoDto implements Serializable {
    private final Long id;
    @JsonFormat(pattern="dd/MM/yyyy")
    private final Date dataEntrada;
    @JsonFormat(pattern="dd/MM/yyyy")
    private final Date dataSaida;
    private final String diagnostico;
    private final Paciente paciente;
    private final Profissional profissional;

    public InternacaoDto(Long id, Date dataEntrada, Date dataSaida, String diagnostico, Paciente paciente, Profissional profissional) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.diagnostico = diagnostico;
        this.paciente = paciente;
        this.profissional = profissional;
    }

    public Long getId() {
        return id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternacaoDto entity = (InternacaoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.dataEntrada, entity.dataEntrada) &&
                Objects.equals(this.dataSaida, entity.dataSaida) &&
                Objects.equals(this.diagnostico, entity.diagnostico) &&
                Objects.equals(this.paciente, entity.paciente) &&
                Objects.equals(this.profissional, entity.profissional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataEntrada, dataSaida, diagnostico, paciente, profissional);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "dataEntrada = " + dataEntrada + ", " +
                "dataSaida = " + dataSaida + ", " +
                "diagnostico = " + diagnostico + ", " +
                "paciente = " + paciente + ", " +
                "profissional = " + profissional + ")";
    }
}
