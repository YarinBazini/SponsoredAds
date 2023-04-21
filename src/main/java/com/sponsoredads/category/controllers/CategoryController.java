package com.sponsoredads.category.controllers;

import com.sponsoredads.category.entity.Category;
import com.sponsoredads.category.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sponsoredads.utils.Utils.CATEGORY_CONTROLLER_MAPPING;
import static com.sponsoredads.utils.Utils.GET_ALL_CATEGORIES_MAPPING;

@RestController
@RequestMapping(CATEGORY_CONTROLLER_MAPPING)
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping(GET_ALL_CATEGORIES_MAPPING)
    public List<Category> getAllCategories()
    {
        return this.categoryService.getAllCategories();
    }

    @PostMapping()
    public void createCategory(@RequestParam String name) {
        this.categoryService.createCategory(name);
    }
}
