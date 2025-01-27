package com.example.consumerEvaluacion.controller;

import com.example.consumerEvaluacion.model.Evento;
import com.example.consumerEvaluacion.model.ApiResponse;
import com.example.consumerEvaluacion.service.ConsumerService;
import com.example.consumerEvaluacion.service.EventoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final ConsumerService consumerService;
    private final EventoService eventoService;

    public EventoController(ConsumerService consumerService, EventoService eventoService) {
        this.consumerService = consumerService;
        this.eventoService = eventoService;
    }

    @GetMapping
    public Flux<Evento> listar() {
        consumerService.streamMessages();
        return eventoService.findAll();
    }
}
