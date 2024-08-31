package com.example.segundaentrega.controller;

import com.example.segundaentrega.model.Product;
import com.example.segundaentrega.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/agregar")
    public Product agregarProduct(@RequestBody Product product) {
        return productService.agregarProduct(product);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Product> buscarProduct(@PathVariable Long id) {
        return productService.buscarProduct(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProduct(@PathVariable Long id) {
        productService.eliminarProduct(id);
    }
    @PutMapping("/actualizar/{id}")
    public Product actualizarProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.actualizarProduct(id, product);
    }
}
