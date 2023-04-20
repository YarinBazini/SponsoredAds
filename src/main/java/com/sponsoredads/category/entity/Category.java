package com.sponsoredads.category.entity;


import com.sponsoredads.products.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Category {
        @Id
        @Column(nullable = false, length = 40)
        private String name;

        @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
        @Singular
        private List<Product> products;
}
