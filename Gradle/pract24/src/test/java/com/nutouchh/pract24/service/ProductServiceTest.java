package com.nutouchh.pract24.service;

import com.nutouchh.pract24.repository.ProductRepository;
import com.nutouchh.pract24.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        productService = new ProductService(productRepository);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());
        Mockito.when(productRepository.findAll()).thenReturn(productList);
        List<Product> allProducts = productService.getAllProducts();
        assertThat(allProducts).isEqualTo(productList);
    }

    @Test
    public void testAddEntity() {
        Product product = new Product();
        productService.addEntity(product);
        Mockito.verify(productRepository).save(product);
    }

    @Test
    public void testDeleteEntity() {
        String name = "my product";
        String price = "12345";
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(name, price));
        Mockito.when(productRepository.findByNameAndPrice(name, price)).thenReturn(productList);
        productService.deleteEntity(name, price);
        Mockito.verify(productRepository).deleteAll(productList);
    }

    @Test
    public void testSortProductsOrderedByName() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("my product 1", "67890"));
        productList.add(new Product("my product 2", "12345"));
        Mockito.when(productRepository.findAll((Sort) Mockito.any())).thenReturn(productList);
        List<Product> sortedProducts = productService.sortProductsOrderedByName();
        assertThat(sortedProducts).containsExactly(productList.get(0), productList.get(1));
    }

    @Test
    public void testFilterProductsByPrice() {
        String price = "12345";
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("my product", price));
        Mockito.when(productRepository.findByPrice(price)).thenReturn(productList);
        List<Product> filteredProducts = productService.filterProductsByPrice(price);
        assertThat(filteredProducts).isEqualTo(productList);
    }
}