package org.example.ecommserviceproduct.productservice.repositories;
import org.example.ecommserviceproduct.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepository extends JpaRepository<Product, String> {
}
