package otus.xellnelix.service;

import otus.xellnelix.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findByVendorName(String name);

    List<Product> findAll();
}
