package com.catalog.project.service;

import com.catalog.project.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;


import java.io.IOException;
import java.util.List;

@Service
public class ProductLoaderService {

    @Autowired
    private CsvParserService csvParserService;

    private List<Product> products;

    @PostConstruct
    public void loadProducts() throws IOException {
        String filePath = new ClassPathResource("static/jcpenney_com-ecommerce_sample.csv").getFile().getAbsolutePath();
        try {
            products = csvParserService.parseCsvToProducts(filePath);
            System.out.println("Products loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
