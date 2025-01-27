package com.example.consumerEvaluacion.repository;

import com.example.consumerEvaluacion.model.Evento;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

public interface EventoRepository extends ReactiveMongoRepository<Evento, String> {
}
