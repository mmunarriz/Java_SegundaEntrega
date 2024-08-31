package com.example.segundaentrega.repository;

import com.example.segundaentrega.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }
