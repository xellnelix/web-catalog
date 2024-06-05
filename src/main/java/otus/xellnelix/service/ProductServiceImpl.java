package otus.xellnelix.service;

import org.springframework.stereotype.Service;
import otus.xellnelix.entity.Product;
import otus.xellnelix.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByVendorName(String name) {
        return new ArrayList<>(productRepository.findByVendorName(name));
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }
}
