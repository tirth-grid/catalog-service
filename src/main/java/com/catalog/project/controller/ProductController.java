package com.catalog.project.controller;
import com.catalog.project.model.Product;
import com.catalog.project.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{uniqId}")
    public Product getByUniqId(@PathVariable String uniqId) {
        return productService.getByUniqId(uniqId);
    }

    @GetMapping
    public List<Product> getBySku(@RequestParam String sku) {
        return productService.getBySku(sku);
    }
}

