package otus.xellnelix.controller;

import org.springframework.web.bind.annotation.*;
import otus.xellnelix.dto.input.ProductCreateDto;
import otus.xellnelix.dto.output.ProductResponseDto;
import otus.xellnelix.mapper.ProductMapper;
import otus.xellnelix.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping("/products/add")
    public ProductResponseDto addProduct(@RequestBody ProductCreateDto productCreateDto) {
        return productService.save(productMapper.toProduct(productCreateDto));
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getProducts() {
        return productService.findAll();
    }

    @PatchMapping("/products/{id}")
    public ProductResponseDto updateProduct(@RequestBody ProductCreateDto productCreateDto, @PathVariable Long id) {
        return productService.updateProduct(productMapper.toProduct(productCreateDto), id);
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/products/{id}")
    public ProductResponseDto deleteProduct(@PathVariable Long id) {
        return productService.deleteById(id);
    }
}
