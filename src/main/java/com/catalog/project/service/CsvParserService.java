package com.catalog.project.service;

import com.catalog.project.model.Product;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvParserService {

    public List<Product> parseCsvToProducts(String filePath) throws IOException {
        List<Product> validProducts = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(reader)
                    .withType(Product.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withThrowExceptions(false) // Skip invalid rows
                    .build();

            csvToBean.parse().forEach(product -> {
                if (isValidProduct(product)) {
                    validProducts.add(product);
                } else {
                    System.err.println("Invalid product data: " + product);
                }
            });
        }
        return validProducts;
    }

    private boolean isValidProduct(Product product) {
        // Example validation logic
        return product.getSku() != null && !product.getSku().isEmpty()
                && product.getListPrice() != null && product.getListPrice() >= 0;
    }
}