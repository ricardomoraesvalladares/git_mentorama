package br.com.ricardo.Filme.consumer;

import br.com.ricardo.Filme.model.Filme;
import br.com.ricardo.Filme.repository.FilmeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    FilmeRepository filmeRepository;

    @JmsListener(destination = "filme-queue")
    public void consumeMessage(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Filme filme = mapper.readValue(message, Filme.class);
        filmeRepository.save(filme).subscribe();
        logger.info(filme.getTitulo() + " Salvo com sucesso.");
    }
}
