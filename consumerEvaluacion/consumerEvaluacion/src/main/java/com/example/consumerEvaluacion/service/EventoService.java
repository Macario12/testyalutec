package com.example.consumerEvaluacion.service;

import com.example.consumerEvaluacion.model.Evento;
import com.example.consumerEvaluacion.repository.EventoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Flux<Evento> findAll() {
        return eventoRepository.findAll();
    }

    public Mono<Evento> create(Evento evento) {
        return eventoRepository.save(evento);
    }
}
