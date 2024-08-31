package com.example.segundaentrega.service;

import com.example.segundaentrega.model.SalesProduct;
import com.example.segundaentrega.repository.SalesProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesProductService {

    @Autowired
    private SalesProductRepository salesProductRepository;

    public SalesProduct agregarSalesProduct(SalesProduct salesProduct) {
        return salesProductRepository.save(salesProduct);
    }

    public Optional<SalesProduct> buscarSalesProduct(Long id) {
        return salesProductRepository.findById(id);
    }

    public void eliminarSalesProduct(Long id) {
        salesProductRepository.deleteById(id);
    }

    public SalesProduct actualizarSalesProduct(Long id, SalesProduct salesProduct) {
        Optional<SalesProduct> salesProductExistente = salesProductRepository.findById(id);

        if (salesProductExistente.isPresent()) {
            SalesProduct actual = salesProductExistente.get();
            actual.setSale(salesProduct.getSale());
            actual.setProduct(salesProduct.getProduct());
            actual.setQuantity(salesProduct.getQuantity());
            return salesProductRepository.save(actual);
        } else {
            return null;
        }
    }
}

