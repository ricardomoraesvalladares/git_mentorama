package br.com.hospital.hospital.Service;

import br.com.hospital.hospital.DTO.InternacaoDto;
import br.com.hospital.hospital.DTO.ResultadosConsultasDto;
import br.com.hospital.hospital.Entity.Internacao;
import org.jetbrains.annotations.NotNull;


public interface IServiceHospital {

    static @NotNull ResultadosConsultasDto converteStringParaObjeto(@NotNull String valor){
        String [] resultado = valor.split(",");
        return new ResultadosConsultasDto(resultado[0], Integer.parseInt(resultado[1]));
    }

    static @NotNull InternacaoDto converteParaInternacaoDTO(@NotNull Internacao internacao) {

        return new InternacaoDto(internacao.getId(),
                internacao.getDataEntrada(), internacao.getDataSaida(),
                internacao.getDiagnostico(),internacao.getPaciente(),
                internacao.getProfissional());
    }
}
