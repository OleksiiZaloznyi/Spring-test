package org.example.service;

import org.example.model.Product;
import java.util.List;

public interface ProductService {
    public Product save(Product product);

    public List<Product> findAll();

}
