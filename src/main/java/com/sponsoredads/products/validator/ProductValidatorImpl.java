package com.sponsoredads.products.validator;

import com.sponsoredads.enums.ErrorMsgEnum;
import com.sponsoredads.exceptions.SponsoredAdsException;
import com.sponsoredads.products.entity.Product;
import com.sponsoredads.products.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductValidatorImpl implements ProductValidator {
    private final ProductsRepository productsRepository;

    @Override
    public void validateProduct(Product product) throws SponsoredAdsException {
        if (isSerialNumberExist(product.getSerialNumber())) {
            throw new SponsoredAdsException(ErrorMsgEnum.SERIAL_NUMBER_ALREADY_EXIST, product.getSerialNumber());
        }
    }

    private boolean isSerialNumberExist(String serialNumber) {
        return this.productsRepository.existsBySerialNumber(serialNumber);
    }
}
