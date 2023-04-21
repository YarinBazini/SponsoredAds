package com.sponsoredads.products.controllers;

import com.sponsoredads.exceptions.SponsoredAdsException;
import com.sponsoredads.products.entity.Product;
import com.sponsoredads.products.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sponsoredads.utils.Utils.*;

@RestController
@RequestMapping(PRODUCT_CONTROLLER_MAPPING)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(GET_ALL_PRODUCTS_MAPPING)
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PostMapping()
    public void createNewProduct(@RequestBody Product product, @RequestParam String categoryName) throws SponsoredAdsException {
        this.productService.createProduct(product, categoryName);
    }

    @GetMapping(SERVE_AD_MAPPING)
    public Product serveAd(@RequestParam String categoryName) throws SponsoredAdsException {
        return this.productService.serveAd(categoryName);
    }
}
