package com.example.segundaentrega.controller;

import com.example.segundaentrega.model.SalesProduct;
import com.example.segundaentrega.service.SalesProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sales-products")
public class SalesProductController {

    @Autowired
    private SalesProductService salesProductService;

    @PostMapping("/agregar")
    public SalesProduct agregarSalesProduct(@RequestBody SalesProduct salesProduct) {
        return salesProductService.agregarSalesProduct(salesProduct);
    }

    @GetMapping("/buscar/{id}")
    public Optional<SalesProduct> buscarSalesProduct(@PathVariable Long id) {
        return salesProductService.buscarSalesProduct(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarSalesProduct(@PathVariable Long id) {
        salesProductService.eliminarSalesProduct(id);
    }

    @PutMapping("/actualizar/{id}")
    public SalesProduct actualizarSalesProduct(@PathVariable Long id, @RequestBody SalesProduct salesProduct) {
        return salesProductService.actualizarSalesProduct(id, salesProduct);
    }
}

