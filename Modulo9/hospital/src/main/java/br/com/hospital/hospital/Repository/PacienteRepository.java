package br.com.hospital.hospital.Repository;

import br.com.hospital.hospital.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Async("asyncExecutor")
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    CompletableFuture<List<Paciente>> findAllBy();
}