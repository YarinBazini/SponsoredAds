package com.sponsoredads.products.validator;

import com.sponsoredads.exceptions.SponsoredAdsException;
import com.sponsoredads.products.entity.Product;

public interface ProductValidator {
    void validateProduct(Product product) throws SponsoredAdsException;
}
