package com.geekbrains.java.springboot.repositories;

import com.geekbrains.java.springboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepo extends JpaRepository<Product, Long> {

}