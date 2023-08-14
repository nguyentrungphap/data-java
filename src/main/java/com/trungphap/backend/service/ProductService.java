package com.trungphap.backend.service;

import java.util.List;
import com.trungphap.backend.entity.Product;
public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long productId);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    void deleteProduct(Long productId);
}
