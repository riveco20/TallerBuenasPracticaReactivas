package com.tallerpruebasreactivas.testStepVerifier.service;

import org.springframework.stereotype.Service;
import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class Servicio {

    public Mono<String> buscarUno() {
        return Mono.just("Pedro");
    }
    public Flux<String> buscarTodos() {
        return Flux.just("Pedro", "Maria", "Jesus", "Carmen");
    }
    public Flux<String> buscarTodosLento() {
        return Flux.just("Pedro", "Maria", "Jesus", "Carmen").delaySequence(Duration.ofSeconds(5));
    }

    public Flux<String> buscarTodosFiltro() {
        Flux<String> source = Flux.just("John", "Monica", "Mark", "Cloe", "Frank", "Casper", "Olivia", "Emily", "Cate")
                .filter(name -> name.length() == 4)
                .map(String::toUpperCase);
        Mono.error(new IllegalArgumentException("Mensaje de Error"));
        return source;
    }



}
