package com.sponsoredads.products.repositories;

import com.sponsoredads.category.entity.Category;
import com.sponsoredads.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findProductBySerialNumber(String serialNumber);
    boolean existsBySerialNumber(String serialNumber);
}
