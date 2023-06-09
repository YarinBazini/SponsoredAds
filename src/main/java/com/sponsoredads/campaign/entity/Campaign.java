package com.sponsoredads.campaign.entity;

import com.sponsoredads.products.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.sponsoredads.utils.Utils.MAX_ACTIVE_CAMPAIGN_LEN;

@Entity
@Table(name = "campaigns")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String campaignName;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private int bid;

    @ManyToMany
    @JoinTable(
            name = "campaign_product",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    public boolean isActive() {
        LocalDate currentDate = LocalDate.now();
        LocalDate startDateMinus10Days = currentDate.minusDays(MAX_ACTIVE_CAMPAIGN_LEN);
        return startDate.compareTo(startDateMinus10Days) >= 0 && startDate.compareTo(currentDate) <= 0;
    }
}
