package com.sponsoredads.campaign.services;

import com.sponsoredads.campaign.dtos.CampaignCreateRequestDto;
import com.sponsoredads.campaign.entity.Campaign;
import com.sponsoredads.exceptions.SponsoredAdsException;

import java.util.List;

public interface CampaignService {
    void createNewCampaign(CampaignCreateRequestDto campaignCreateRequestDto) throws SponsoredAdsException;
    List<Campaign> getAllCampaigns();
}
