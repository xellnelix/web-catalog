package otus.xellnelix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import otus.xellnelix.dto.ProductDto;
import otus.xellnelix.entity.Product;
import otus.xellnelix.mapper.ProductMapper;
import otus.xellnelix.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public ProductDto updateProduct(Product product, Long id) {
        if (!productRepository.existsById(id)) {
            log.info("Product with id = {} not exists", id);
            return null;
        }
        Product foundProduct = productRepository.findById(id).orElseThrow();
        if (product.getName() != null) {
            foundProduct.setName(product.getName());
        }
        if (product.getPrice() != null) {
            foundProduct.setPrice(product.getPrice());
        }
        if (product.getQuantity() != null) {
            foundProduct.setQuantity(product.getQuantity());
        }
        return ProductMapper.toDto(Optional.of(productRepository.save(foundProduct)));
    }

    @Override
    public ProductDto findById(Long id) {
        if (productRepository.existsById(id)) {
            return ProductMapper.toDto(productRepository.findById(id));
        }

        log.info("Product with id {} not found", id);
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }
}
