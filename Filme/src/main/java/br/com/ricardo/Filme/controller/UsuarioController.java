package br.com.ricardo.Filme.controller;

import br.com.ricardo.Filme.model.Usuario;
import br.com.ricardo.Filme.repository.UsuarioReprository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioReprository usuarioReprository;

    public UsuarioController(UsuarioReprository usuarioReprository) {
        this.usuarioReprository = usuarioReprository;
    }

    @GetMapping
    public Flux<Usuario> getAll(){
        return usuarioReprository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Usuario> create(@RequestBody Usuario usuario){
        return usuarioReprository.save(usuario);
    }
}
