package br.com.ricardo.Filme.repository;

import br.com.ricardo.Filme.model.Filme;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FilmeRepository extends R2dbcRepository<Filme, Long> {

    @Query(value = "SELECT * FROM filme f WHERE f.usuario_id = :user_id")
    public Flux<Filme> buscaFilmesDoUsuario(Long user_id);

    @Query(value = "SELECT COUNT(*) FROM filme f WHERE f.usuario_id = :user_id AND f.titulo = :titulo ")
    public Mono<Integer> buscaTitulodoDoUsuario(Long user_id, String titulo);
}
