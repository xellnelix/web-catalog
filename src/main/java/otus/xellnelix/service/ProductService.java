package otus.xellnelix.service;

import otus.xellnelix.dto.ProductDto;
import otus.xellnelix.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void saveProduct(Product product);

    ProductDto updateProduct(Product product, Long id);

    ProductDto findById(Long id);

    List<Product> findAll();
}
