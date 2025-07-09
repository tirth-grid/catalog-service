package com.catalog.project.service;

import com.catalog.project.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductLoaderService productLoaderService;

    private List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void init() {
        productList = productLoaderService.getProducts();
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public Product getByUniqId(String uniqId) {
        return productList.stream().filter(product -> product.getUniqId().equals(uniqId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product with uniqId " + uniqId + " not found"));
    }

    public List<Product> getBySku(String sku) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getSku() != null && product.getSku().equalsIgnoreCase(sku)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<String> getAllProductIds() {
        List<String> productIds = new ArrayList<>();
        for (Product product : productList) {
            if (product.getUniqId() != null) {
                productIds.add(product.getUniqId());
            }
        }
        return productIds;
    }
}

