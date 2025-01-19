package khabibullin.interviewtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import khabibullin.interviewtask.entity.Product;
import khabibullin.interviewtask.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private ResponseEntity<Product> mappingResponseEntity(Product product) {
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    private ResponseEntity<List<Product>> mappingResponseEntityList(List<Product> products) {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return mappingResponseEntity(productService.create(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> readAll() {
        return mappingResponseEntityList(productService.readAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Product>> readByName(@PathVariable("name") String name) {
        return mappingResponseEntityList(productService.readByName(name));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return mappingResponseEntity(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return HttpStatus.OK;
    }
}
