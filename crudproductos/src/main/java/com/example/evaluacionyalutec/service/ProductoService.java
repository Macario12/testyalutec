package com.example.evaluacionyalutec.service;

import com.example.evaluacionyalutec.model.Producto;
import com.example.evaluacionyalutec.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final KafkaProducer kafkaProducer;

    public ProductoService(ProductoRepository productoRepository, KafkaProducer kafkaProducer) {
        this.productoRepository = productoRepository;
        this.kafkaProducer = kafkaProducer;
    }

    public Flux<Producto> getAllProducts() {
        return productoRepository.findAll();
    }

    public Mono<Producto> getProductById(String id) {
        return productoRepository.findById(id);
    }

    public Mono<Producto> createProduct(Producto producto) {
        kafkaProducer.sendMessage("webflux-topic",producto.getNombre(),producto.getCantidad());
        return productoRepository.save(producto);
    }

    public Mono<Producto> updateProduct(String id, Producto producto) {
        return productoRepository.findById(id)
                .flatMap(p -> {
                    p.setNombre(producto.getNombre());
                    p.setPrecio(producto.getPrecio());
                    p.setCantidad(producto.getCantidad());
                    return productoRepository.save(p);
                });
    }

    public Mono<Void> deleteProduct(String id) {
        return productoRepository.deleteById(id);
    }
}
