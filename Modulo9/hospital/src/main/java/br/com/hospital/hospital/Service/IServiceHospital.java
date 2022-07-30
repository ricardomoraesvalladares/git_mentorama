package br.com.hospital.hospital.Service;

import br.com.hospital.hospital.DTO.ResultadosConsultasDto;


public interface IServiceHospital {

    public static ResultadosConsultasDto converteStringParaObjeto(String valor){
        String [] resultado = valor.split(",");
        return new ResultadosConsultasDto(resultado[0], Integer.parseInt(resultado[1]));
    }
}
