package com.nurouchh.pract15.controllers;

import com.nurouchh.pract15.classes.Product;
import com.nurouchh.pract15.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
