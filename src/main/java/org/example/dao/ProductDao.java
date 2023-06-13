package org.example.dao;

import org.example.model.Product;
import java.util.List;

public interface ProductDao {
    Product save(Product product);

//    Product get(Long id);
//
//    Product remove(Product product);

    List<Product> findAll();


}
