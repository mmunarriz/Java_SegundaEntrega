package com.example.segundaentrega.service;

import com.example.segundaentrega.model.Product;
import com.example.segundaentrega.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product agregarProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> buscarProduct(Long id) {
        return productRepository.findById(id);
    }

    public void eliminarProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product actualizarProduct(Long id, Product product) {
        Optional<Product> productExistente = productRepository.findById(id);

        if (productExistente.isPresent()) {
            Product actual = productExistente.get();
            actual.setName(product.getName());
            actual.setPrice(product.getPrice());
            actual.setStock(product.getStock());
            return productRepository.save(actual);
        } else {
            return null;
        }
    }
}
