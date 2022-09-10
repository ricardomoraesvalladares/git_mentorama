package br.com.ricardo.Filme.repository;

import br.com.ricardo.Filme.model.Usuario;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface UsuarioReprository extends R2dbcRepository<Usuario, Long> {
}
