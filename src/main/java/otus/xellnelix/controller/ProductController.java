package otus.xellnelix.controller;

import org.springframework.web.bind.annotation.*;
import otus.xellnelix.dto.ProductDto;
import otus.xellnelix.mapper.ProductMapper;
import otus.xellnelix.service.ProductService;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product/add")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(ProductMapper.toEntity(productDto));
    }

    @GetMapping("/product/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PatchMapping("/product/update/{id}")
    public ProductDto updateProductName(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(ProductMapper.toEntity(productDto), id);
    }
}
