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
    public void createCampaign(@RequestBody CampaignCreateRequestDto campaignCreateRequestDto) throws SponsoredAdsException {
        this.campaignService.createNewCampaign(campaignCreateRequestDto);
    }

    @GetMapping("/all")
    public List<Campaign> getAllCampaign(){
        return this.campaignService.getAllCampaigns();
    }
}
