package com.example.evaluacionyalutec.repository;

import com.example.evaluacionyalutec.model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {
}