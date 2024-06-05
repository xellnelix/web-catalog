package otus.xellnelix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import otus.xellnelix.entity.Product;
import otus.xellnelix.entity.Vendor;
import otus.xellnelix.service.ProductService;
import otus.xellnelix.service.VendorService;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private final VendorService vendorService;
    @Autowired
    private final ProductService productService;

    public TestController(VendorService vendorService, ProductService productService) {
        this.vendorService = vendorService;
        this.productService = productService;
    }

    @PostMapping("/vendor/save")
    public Vendor saveVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    @GetMapping("/vendor/find")
    public List<Vendor> findAllVendor() {
        return vendorService.findAll();
    }

    @GetMapping("/product/find/name")
    public List<Product> findProductByVendorName(@RequestParam String name) {
        return productService.findByVendorName(name);
    }

    @GetMapping("/product/find")
    public List<Product> findAllProduct() {
        return productService.findAll();
    }
}
