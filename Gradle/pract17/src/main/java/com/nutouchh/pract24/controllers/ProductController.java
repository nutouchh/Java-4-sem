package com.nutouchh.pract24.controllers;

import com.nutouchh.pract24.model.Product;
import com.nutouchh.pract24.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Product> showProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam String price) {
        productService.addEntity(new Product(name, price));
        return "redirect:/products/";
    }


    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("name") String name,
                                @RequestParam("price") String price) {
        productService.deleteEntity(new Product(name, price));
        return "redirect:/products/";
    }

    @GetMapping("/sorted_by_name")
    @ResponseBody
    public String showProductsOrderedByName() {
        return productService.sortProductsOrderedByName().toString();
    }

    @GetMapping("/{price}")
    @ResponseBody
    public String showProductsByPrice(@PathVariable String price) {
        return  productService.filterProductsByPrice(price).toString();
    }
}
