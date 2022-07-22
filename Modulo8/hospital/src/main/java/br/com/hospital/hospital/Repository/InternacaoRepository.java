package br.com.hospital.hospital.Repository;

import br.com.hospital.hospital.Entity.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InternacaoRepository extends JpaRepository<Internacao, Long> {

    @Query(value = "select p.nome, count(i.id_paciente) as contaPaciente from internacao i\n" +
            "inner join pacientes p \n" +
            "on i.id_paciente = p.id\n" +
            "group by p.nome\n" +
            "order by contaPaciente desc ", nativeQuery = true)
   List<String> listaPacientesComMaisInternacoes();
}