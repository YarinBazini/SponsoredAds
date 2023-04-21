package com.sponsoredads.category.services;

import com.sponsoredads.category.entity.Category;
import com.sponsoredads.category.repositories.CategoryRepository;
import com.sponsoredads.enums.ErrorMsgEnum;
import com.sponsoredads.exceptions.SponsoredAdsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(String name) {
        Category category = Category.builder().name(name).build();
        this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByName(String name) throws SponsoredAdsException {
        return this.categoryRepository.findByName(name).orElseThrow(()->{
            return new SponsoredAdsException(ErrorMsgEnum.CATEGORY_NOT_EXIST, name);
        });
    }
}
