package otus.xellnelix.service;

import otus.xellnelix.dto.output.ProductResponseDto;
import otus.xellnelix.entity.Product;

import java.util.List;

public interface ProductService {
    ProductResponseDto save(Product product);

    ProductResponseDto updateProduct(Product product, Long id);

    ProductResponseDto findById(Long id);

    ProductResponseDto deleteById(Long id);

    List<ProductResponseDto> findAll();
}
