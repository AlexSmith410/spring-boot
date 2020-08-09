package com.geekbrains.java.springboot.services;

import com.geekbrains.java.springboot.exceptions.ResourceNotFoundException;
import com.geekbrains.java.springboot.models.Product;
import com.geekbrains.java.springboot.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "ProductService")
public class ProductService {
    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public Product getProductById(Long id){
        return productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Нет продукта с таким id"));
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public void saveProduct(Product product){
        productRepo.save(product);
    }

    public void removeProductById(Long id){
        productRepo.deleteById(id);
    }
}