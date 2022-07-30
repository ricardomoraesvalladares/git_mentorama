package br.com.hospital.hospital.Repository;

import br.com.hospital.hospital.Entity.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Async("asyncExecutor")
public interface InternacaoRepository extends JpaRepository<Internacao, Long> {


    //seleciona pacientes com mais internações ** tem que criar dto ***
    @Query(value = "select p.nome, count(i.id_paciente) as contaPaciente from internacao i\n" +
            "inner join pacientes p \n" +
            "on i.id_paciente = p.id\n" +
            "group by p.nome\n" +
            "order by contaPaciente desc ", nativeQuery = true)
   List<String> listaPacientesComMaisInternacoes();

   CompletableFuture<List<Internacao>> findAllBy();
}