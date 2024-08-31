package com.example.segundaentrega.controller;

import com.example.segundaentrega.model.Customer;
import com.example.segundaentrega.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/agregar")
    public Customer agregarCustomer(@RequestBody Customer customer) {
        return customerService.agregarCustomer(customer);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Customer> buscarCustomer(@PathVariable Long id) {
        return customerService.buscarCustomer(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCustomer(@PathVariable Long id) { customerService.eliminarCustomer(id);
    }

    @PutMapping("/actualizar/{id}")
    public Customer actualizarCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.actualizarCustomer(id, customer);
    }

}
