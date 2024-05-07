package org.example.ecommserviceproduct.productservice.controller;
import org.example.ecommserviceproduct.productservice.models.Product;
import org.example.ecommserviceproduct.productservice.repositories.IProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    IProductRepository productRepository;

    ProductController(IProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct()
    {
        List<Product> products = new ArrayList<>();
        return  ResponseEntity.ok(products);
    }

    @GetMapping("{productId}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable String productId)
    {
        if(productId == null || productId.isEmpty())
        {
            return ResponseEntity.badRequest().build();
        }

        Optional<Product> product = productRepository.findById(productId);
        return  ResponseEntity.ok(product);
    }

    @PostMapping
    public  ResponseEntity<String> createProduct(@RequestBody Product product)
    {
        if(product == null)
        {
            return  ResponseEntity.badRequest().build();
        }

        product.setId(UUID.randomUUID().toString());
        productRepository.save(product);
        return  ResponseEntity.ok("Product created with id " + product.getId());
    }
}
