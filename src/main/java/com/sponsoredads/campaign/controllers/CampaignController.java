package com.sponsoredads.campaign.controllers;

import com.sponsoredads.campaign.dtos.CampaignCreateRequestDto;
import com.sponsoredads.campaign.entity.Campaign;
import com.sponsoredads.campaign.services.CampaignService;
import com.sponsoredads.exceptions.SponsoredAdsException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaign")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;

    @PostMapping()
    public Campaign createCampaign(@RequestBody CampaignCreateRequestDto campaignCreateRequestDto) throws SponsoredAdsException {
        return this.campaignService.createNewCampaign(campaignCreateRequestDto);
    }

    @GetMapping("/all")
    public List<Campaign> getAllCampaign(){
        return this.campaignService.getAllCampaigns();
    }
}
