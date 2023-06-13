package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/*
1. ClassName: ProductServiceImpl.Class
2. Implemented interfaces: [ProductService.Class]
3. Dependent beans: [productDao]
4. Annotations: [Service]
*/
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
