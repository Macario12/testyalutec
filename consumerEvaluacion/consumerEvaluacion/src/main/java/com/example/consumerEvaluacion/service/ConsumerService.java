package com.example.consumerEvaluacion.service;

import com.example.consumerEvaluacion.model.Evento;
import com.example.consumerEvaluacion.service.EventoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final EventoService eventoService;
    private final Sinks.Many<String> sink = Sinks.many().multicast().onBackpressureBuffer();

    public ConsumerService(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @KafkaListener(topics = "webflux-topic", groupId = "webflux-group")
    public void consume(String mensaje) {
        sink.tryEmitNext(mensaje); // Emitir el mensaje en el flujo
    }

    public void streamMessages() {
         sink.asFlux().flatMap(evento -> eventoService.create(new Evento(evento))) // Guardar en la base de datos
                 .doOnNext(savedEvento -> System.out.println("Evento guardado: " + savedEvento))
                 .doOnError(error -> System.err.println("Error al guardar el evento: " + error.getMessage()))
                 .subscribe();
    }
}
