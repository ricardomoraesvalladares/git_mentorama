package br.com.ricardo.Filme.controller;

import br.com.ricardo.Filme.consumer.Consumer;
import br.com.ricardo.Filme.model.Filme;
import br.com.ricardo.Filme.model.FilmeVO;
import br.com.ricardo.Filme.repository.FilmeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.jms.Queue;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private final FilmeRepository filmeRepository;
    private final JmsTemplate jmsTemplate;
    private final Queue queue;

    private static final Logger logger = LoggerFactory.getLogger(FilmeController.class);

    public FilmeController(FilmeRepository filmeRepository, JmsTemplate jmsTemplate, Queue queue) {
        this.filmeRepository = filmeRepository;
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    @GetMapping("/{usuario_id}")
    public Flux<Filme> ListaFilmesDoUsuario(@PathVariable(value = "usuario_id") Long user_id){
        return this.filmeRepository.buscaFilmesDoUsuario(user_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody FilmeVO filme) throws ExecutionException, InterruptedException {
        Filme novoFilme = new Filme
                (filme.getId(), filme.getTitulo(), filme.getNota(),
                        filme.getComentario(), filme.getUsuario_id());
        Integer resultado = filmeRepository.buscaTitulodoDoUsuario
                (novoFilme.getUsuario_id(), novoFilme.getTitulo()).toFuture().join();

        if( resultado == 0 && filme.getNota() >= 0 && filme.getNota() <=5 ){
            try{
                ObjectMapper mapper = new ObjectMapper();
                String filmeAsJson = mapper.writeValueAsString(novoFilme);
                jmsTemplate.convertAndSend(queue,filmeAsJson);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            logger.error("Filme já cadastrado ou nota inválida !!!");
        }
    }
}
