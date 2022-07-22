package br.com.hospital.hospital.Repository;

import br.com.hospital.hospital.Entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    @Query(value = "select departamento, count(departamento) as contaDepartamento \n" +
            "from profissionais p\n" +
            "group by departamento\n" +
            "order by contaDepartamento", nativeQuery = true)
    List<String> listaDepartamentosComMaiorQuantidadeMedicos();
}