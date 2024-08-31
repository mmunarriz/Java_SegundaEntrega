package com.example.segundaentrega.service;

import com.example.segundaentrega.model.Sale;
import com.example.segundaentrega.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Sale agregarSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Optional<Sale> buscarSale(Long id) {
        return saleRepository.findById(id);
    }

    public void eliminarSale(Long id) {
        saleRepository.deleteById(id);
    }

    public Sale actualizarSale(Long id, Sale sale) {
        Optional<Sale> saleExistente = saleRepository.findById(id);

        if (saleExistente.isPresent()) {
            Sale actual = saleExistente.get();
            actual.setDate(sale.getDate());
            actual.setCustomer(sale.getCustomer());
            actual.setTotalAmount(sale.getTotalAmount());
            actual.setSalesProducts(sale.getSalesProducts());
            return saleRepository.save(actual);
        } else {
            return null;
        }
    }
}
