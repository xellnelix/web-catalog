package otus.xellnelix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import otus.xellnelix.dto.output.ProductResponseDto;
import otus.xellnelix.dto.output.UserResponseDto;
import otus.xellnelix.entity.Product;
import otus.xellnelix.entity.User;
import otus.xellnelix.mapper.ProductMapper;
import otus.xellnelix.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public ProductResponseDto saveProduct(Product product) {
        return productMapper.toProductResponseDto(productRepository.save(product));
    }

    @Override
    public ProductResponseDto updateProduct(Product product, Long id) {
        if (!productRepository.existsById(id)) {
            logNotFound(id);
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
        return productMapper.toProductResponseDto(productRepository.save(foundProduct));
    }

    @Override
    public ProductResponseDto findById(Long id) {
        Optional<Product> foundUser = productRepository.findById(id);
        return foundUser.map(productMapper::toProductResponseDto).orElse(null);
    }

    @Override
    public ProductResponseDto deleteById(Long id) {
        Optional<Product> deletedProduct = productRepository.findById(id);
        if (deletedProduct.isPresent()) {
            productRepository.deleteById(id);
            return productMapper.toProductResponseDto(deletedProduct.get());
        }
        log.info("Product with id = {} not found", id);
        return null;
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return productMapper.toProductResponseDtoList((List<Product>) productRepository.findAll());
    }

    private void logNotFound(Long id) {
        log.info("Product with id = {} not exists", id);
    }
}
