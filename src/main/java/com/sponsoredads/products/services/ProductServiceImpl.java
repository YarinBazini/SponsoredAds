package com.sponsoredads.products.services;

import com.sponsoredads.category.entity.Category;
import com.sponsoredads.category.services.CategoryService;
import com.sponsoredads.exceptions.SponsoredAdsException;
import com.sponsoredads.products.entity.Product;
import com.sponsoredads.products.repositories.ProductsRepository;
import com.sponsoredads.products.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductsRepository productsRepository;
    private final CategoryService categoryService;
    private final ProductValidator productValidator;

    @Override
    public List<Product> getAllProducts() {
        return this.productsRepository.findAll();
    }

    @Override
    public void createProduct(Product product, String categoryName) throws SponsoredAdsException {
        this.productValidator.validateProduct(product);
        Category category = this.categoryService.getCategoryByName(categoryName);
        category.getProducts().add(product);
        product.setCategory(category);
        this.productsRepository.save(product);
    }
}
