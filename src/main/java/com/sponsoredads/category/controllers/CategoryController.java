package com.sponsoredads.category.controllers;

import com.sponsoredads.category.entity.Category;
import com.sponsoredads.category.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @PostMapping()
    public void createCategory(@RequestParam String name)
    {
        categoryService.createCategory(name);
    }
}
