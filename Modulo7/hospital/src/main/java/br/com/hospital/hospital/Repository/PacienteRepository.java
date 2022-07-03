package br.com.hospital.hospital.Repository;

import br.com.hospital.hospital.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}