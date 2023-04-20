package com.sponsoredads.campaign.services;

import com.sponsoredads.campaign.dtos.CampaignCreateRequestDto;
import com.sponsoredads.campaign.entity.Campaign;
import com.sponsoredads.campaign.repositories.CampaignRepository;
import com.sponsoredads.enums.ErrorMsgEnum;
import com.sponsoredads.exceptions.SponsoredAdsException;
import com.sponsoredads.products.entity.Product;
import com.sponsoredads.products.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService{
    private final CampaignRepository campaignRepository;
    private final ProductsRepository productsRepository;

    @Override
    public void createNewCampaign(CampaignCreateRequestDto campaignCreateRequestDto) throws SponsoredAdsException {
        Campaign campaign = this.createCampaignFromCampaignCreateRequestDto(campaignCreateRequestDto);
        this.updateProductCampaign(campaign);
        this.campaignRepository.save(campaign);
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return this.campaignRepository.findAll();
    }

    private List<Product> getProductsListFromCampaignCreateRequestDto(CampaignCreateRequestDto campaignCreateRequestDto) throws SponsoredAdsException {
        List<Product> products = new ArrayList<>();
        for(String serialNum : campaignCreateRequestDto.getProductsSerialNumbers()){
            products.add(this.productsRepository.findProductBySerialNumber(serialNum).orElseThrow(() -> {
                return new SponsoredAdsException(ErrorMsgEnum.SERIAL_NUMBER_NOT_EXIST, serialNum);
            }));
        }

        return products;
    }

    private void updateProductCampaign(Campaign campaign) {
        for(Product product : campaign.getProducts()){
            product.getCampaigns().add(campaign);
            this.productsRepository.save(product);
        }
    }

    private Campaign createCampaignFromCampaignCreateRequestDto(CampaignCreateRequestDto campaignCreateRequestDto) throws SponsoredAdsException {
        List<Product> products = getProductsListFromCampaignCreateRequestDto(campaignCreateRequestDto);

        return Campaign.builder().
                campaignName(campaignCreateRequestDto.getName()).
                startDate(campaignCreateRequestDto.getStartDate()).
                bid(campaignCreateRequestDto.getBid()).
                products(products).build();
    }
}
