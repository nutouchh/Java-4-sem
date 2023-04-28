package com.nutouchh.pract14.controllers;

import com.nutouchh.pract14.classes.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private List<Product> productList = new ArrayList<>();

    @GetMapping("/")
    @ResponseBody
    public List<Product> showProducts() {
        return productList;
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") String price) {
        productList.add(new Product(name, price));
        return "redirect:/products/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("addressText") String addressText,
                                @RequestParam("price") String price) {
        for (Product prod : productList) {
            if (prod.getName().equals(addressText) && prod.getPrice().equals(price)) {
                productList.remove(prod);
                return "redirect:/products/";
            }
        }
        return "redirect:/products/";
    }
}
