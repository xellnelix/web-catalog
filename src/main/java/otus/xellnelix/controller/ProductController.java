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

    @PostMapping("/product/add")
    public ProductResponseDto addProduct(@RequestBody ProductCreateDto productCreateDto) {
        return productService.saveProduct(productMapper.toProduct(productCreateDto));
    }

    @GetMapping("/product/all")
    public List<ProductResponseDto> findAllProduct() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductResponseDto findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PatchMapping("/product/update/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductCreateDto productCreateDto) {
        return productService.updateProduct(productMapper.toProduct(productCreateDto), id);
    }

    @DeleteMapping("/product/delete/{id}")
    public ProductResponseDto deleteProduct(@PathVariable Long id) {
        return productService.deleteById(id);
    }
}
