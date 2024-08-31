package com.example.segundaentrega.controller;

import com.example.segundaentrega.model.Sale;
import com.example.segundaentrega.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/agregar")
    public Sale agregarSale(@RequestBody Sale sale) {
        return saleService.agregarSale(sale);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Sale> buscarSale(@PathVariable Long id) {
        return saleService.buscarSale(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarSale(@PathVariable Long id) {
        saleService.eliminarSale(id);
    }
    @PutMapping("/actualizar/{id}")
    public Sale actualizarSale(@PathVariable Long id, @RequestBody Sale sale) {
        return saleService.actualizarSale(id, sale);
    }
}
