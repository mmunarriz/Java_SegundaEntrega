package com.example.segundaentrega.service;

import com.example.segundaentrega.model.Customer;
import com.example.segundaentrega.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer agregarCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> buscarCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public void eliminarCustomer(Long id) { customerRepository.deleteById(id);
    }

    public Customer actualizarCustomer(Long id, Customer customer) {
        Optional<Customer> customerExistente = customerRepository.findById(id);

        if (customerExistente.isPresent()) {
            Customer actual = customerExistente.get();
            actual.setName(customer.getName());
            actual.setEmail(customer.getEmail());
            actual.setPhone(customer.getPhone());
            actual.setSales(customer.getSales());
            return customerRepository.save(actual);
        } else {
            return null;
        }
    }

}
