package com.sponsoredads.init;

import com.sponsoredads.category.services.CategoryService;
import com.sponsoredads.exceptions.SponsoredAdsException;
import com.sponsoredads.products.entity.Product;
import com.sponsoredads.products.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/init")
@RequiredArgsConstructor
public class InitDBController {
    private final CategoryService categoryService;
    private final ProductService productService;


    //This APi simply saves in the dataBase a bulk of categories and products.
    @PostMapping()
    void initDB() throws SponsoredAdsException {
        List<String> categories = new ArrayList<>();
        categories.add("Sport");
        categories.add("Bank");
        categories.add("Food");
        categories.add("Snickers");
        for(String category: categories){
            this.categoryService.createCategory(category);
        }
        for(int i = 0; i<20; i++){
            Product product = Product.builder().
                    serialNumber(String.valueOf(i)).
                    title(String.valueOf(i)).
                    price(i).
                    build();
            this.productService.createProduct(product, categories.get(i % categories.size()));
        }
    }
}
