package com.sponsoredads.campaign.repositories;

import com.sponsoredads.campaign.entity.Campaign;
import com.sponsoredads.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}
