package com.sponsoredads.campaign.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CampaignCreateRequestDto {
    private String name;
    private LocalDate startDate;
    private int bid;
    private List<String> productsSerialNumbers;
}
