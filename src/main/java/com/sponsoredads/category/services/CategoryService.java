package com.sponsoredads.category.services;

import com.sponsoredads.category.entity.Category;
import com.sponsoredads.exceptions.SponsoredAdsException;

import java.util.List;

public interface CategoryService {
    void createCategory(String name);

    List<Category> getAllCategories();

    Category getCategoryByName(String name) throws SponsoredAdsException;
}
