package com.sponsoredads.products.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sponsoredads.campaign.entity.Campaign;
import com.sponsoredads.category.entity.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 40)
    private String serialNumber;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private Category category;

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    @JsonIgnore
    private List<Campaign> campaigns = new ArrayList<>();
}
