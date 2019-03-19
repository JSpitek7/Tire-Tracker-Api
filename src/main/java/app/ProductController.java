package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
    @Autowired ProductRepository productRepository;

    @RequestMapping("/products")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
//
    @GetMapping("/products/category/{category}")
    public @ResponseBody Iterable<Product> getProductsByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }

    @GetMapping("products/supplier/{supplier}")
    public @ResponseBody Iterable<Product> getProductsBySupplier(@PathVariable String supplier) {
        return productRepository.findBySupplier(supplier);
    }

    @GetMapping("products/{category}/{supplier}")
    public @ResponseBody Iterable<Product> getProductsByCategoryAndSupplier(@PathVariable String category,
                                                              @PathVariable String supplier) {
        return productRepository.findByCategoryAndSupplier(category,supplier);
    }

    @GetMapping("/categories")
    public @ResponseBody Iterable<String> getCategories() {
        return productRepository.findDistinctCategory();
    }

    @GetMapping("/suppliers")
    public @ResponseBody Iterable<String> getSuppliers() {
        return productRepository.findDistinctSupplier();
    }
}