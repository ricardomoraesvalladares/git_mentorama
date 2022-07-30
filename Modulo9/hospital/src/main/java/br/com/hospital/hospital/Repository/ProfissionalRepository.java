package br.com.hospital.hospital.Repository;

import br.com.hospital.hospital.Entity.Paciente;
import br.com.hospital.hospital.Entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Async("asyncExecutor")
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    //seleciona departamentos com mais medicos  *** tem que terminar
    @Query(value = "select departamento, count(departamento) as contaDepartamento \n" +
            "from profissionais p\n" +
            "group by departamento\n" +
            "order by contaDepartamento", nativeQuery = true)
    List<String> listaDepartamentosComMaiorQuantidadeMedicos();

    CompletableFuture<List<Profissional>> findAllBy();
}