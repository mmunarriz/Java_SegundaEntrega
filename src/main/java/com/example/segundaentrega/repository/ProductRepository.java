package com.example.segundaentrega.repository;

import com.example.segundaentrega.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }

