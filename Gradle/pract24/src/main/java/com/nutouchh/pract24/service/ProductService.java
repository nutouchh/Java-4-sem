package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.Product;
import com.nutouchh.pract24.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
//    private final EmailService emailService;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        log.info("Find all products");
        return productRepository.findAll();
    }

    public void addEntity(Product product) {
        log.info("Saving product: {}", product);
        productRepository.save(product);
    }

    public void deleteEntity(String name, String price) {
        log.info("Removing all products with name = {} and price = {}", name, price);
        List<Product> toDelete = productRepository.findByNameAndPrice(name, price);
        productRepository.deleteAll(toDelete);
    }

    public List<Product> sortProductsOrderedByName() {
        log.info("Getting all products sorted by name");
        return productRepository.findAll(Sort.by("name"));
    }

    public List<Product> filterProductsByPrice(String price) {
        log.info("Getting all products with price = {}", price);
        return productRepository.findByPrice(price);
    }
}
