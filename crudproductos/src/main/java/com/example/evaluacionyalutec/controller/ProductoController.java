package com.example.evaluacionyalutec.controller;

import com.example.evaluacionyalutec.model.Producto;
import com.example.evaluacionyalutec.model.ApiResponse;
import com.example.evaluacionyalutec.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public Flux<Producto> obtenerProductos() {
        return productoService.getAllProducts();
    }

    @PostMapping
    public Mono<ResponseEntity<ApiResponse>> save(@RequestBody Producto producto) {

        if (producto.getNombre() == null || producto.getNombre().isEmpty() || producto.getCantidad() < 0 || producto.getPrecio() < 0) {
            return Mono.just(ResponseEntity.ok().body(new ApiResponse(400, "Uno o mas parametros son incorrectos")));
        }

        return productoService.createProduct(producto).map(p -> ResponseEntity.ok(new ApiResponse(200, "Producto creado correctamente")));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse>> update(@PathVariable String id, @RequestBody Producto producto) {

        if (id == null || id.isEmpty() || producto.getNombre() == null || producto.getNombre().isEmpty() || producto.getCantidad() < 0 || producto.getPrecio() < 0) {
            return Mono.just(ResponseEntity.ok().body(new ApiResponse(400, "Uno o mas parametros son incorrectos")));
        }

        return productoService.updateProduct(id, producto).map(p -> ResponseEntity.ok(new ApiResponse(200, "Producto actualizado correctamente")));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse>> delete(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return Mono.just(ResponseEntity.ok().body(new ApiResponse(400, "Uno o mas parametros son incorrectos")));
        }

        return productoService.deleteProduct(id).then(Mono.just(ResponseEntity.ok(new ApiResponse(200, "Producto eliminado correctamente"))));
    }
}
