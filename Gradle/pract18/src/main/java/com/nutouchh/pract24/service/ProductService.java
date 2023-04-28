package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.Product;
import com.nutouchh.pract24.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addEntity(Product product) {
        productRepository.save(product);
    }

    public void deleteEntity(String name, String price) {
        List<Product> toDelete = productRepository.findByNameAndPrice(name, price);
        productRepository.deleteAll(toDelete);
    }

    public List<Product> sortProductsOrderedByName() {
        return productRepository.findAll(Sort.by("name"));
    }

    public List<Product> filterProductsByPrice(String price) {
        return productRepository.findByPrice(price);
    }
}
