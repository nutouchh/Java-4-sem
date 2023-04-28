package com.nutouchh.pract24.repository;

import com.nutouchh.pract24.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameAndPrice(String name, String price);
    List<Product> findByPrice(String price);

}
