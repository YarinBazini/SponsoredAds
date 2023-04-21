package com.sponsoredads.campaign.controllers;

import com.sponsoredads.campaign.dtos.CampaignCreateRequestDto;
import com.sponsoredads.campaign.entity.Campaign;
import com.sponsoredads.campaign.services.CampaignService;
import com.sponsoredads.exceptions.SponsoredAdsException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sponsoredads.utils.Utils.CAMPAIGN_CONTROLLER_MAPPING;
import static com.sponsoredads.utils.Utils.GET_ALL_CAMPAIGNS_MAPPING;

@RestController
@RequestMapping(CAMPAIGN_CONTROLLER_MAPPING)
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;

    @PostMapping()
    public Campaign createCampaign(@RequestBody CampaignCreateRequestDto campaignCreateRequestDto) throws SponsoredAdsException {
        return this.campaignService.createNewCampaign(campaignCreateRequestDto);
    }

    @GetMapping(GET_ALL_CAMPAIGNS_MAPPING)
    public List<Campaign> getAllCampaign(){
        return this.campaignService.getAllCampaigns();
    }
}
