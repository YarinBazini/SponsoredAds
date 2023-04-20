package com.sponsoredads.products.services;

import com.sponsoredads.exceptions.SponsoredAdsException;
import com.sponsoredads.products.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void createProduct(Product product, String categoryName) throws SponsoredAdsException;
}
