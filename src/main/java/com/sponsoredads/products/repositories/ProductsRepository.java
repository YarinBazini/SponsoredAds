package com.sponsoredads.products.repositories;

import com.sponsoredads.campaign.entity.Campaign;
import com.sponsoredads.category.entity.Category;
import com.sponsoredads.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findProductBySerialNumber(String serialNumber);
    boolean existsBySerialNumber(String serialNumber);
    List<Product> findProductsByCampaignsNotNull();

    @Query(value = "SELECT p.* " +
            "FROM products p " +
            "JOIN campaign_product cp ON cp.product_id = p.id " +
            "JOIN campaigns c ON c.id = cp.campaign_id " +
            "WHERE p.category_name = ?1 " +
            "AND c.start_date BETWEEN DATE_SUB(CURRENT_DATE(),INTERVAL 10 DAY) " +
            "AND CURRENT_DATE() " +
            "AND c.bid = " +
            "(SELECT MAX(bid) " +
            "FROM campaigns c2 " +
            "WHERE c2.start_date " +
            "BETWEEN DATE_SUB(CURRENT_DATE(), INTERVAL 10 DAY)" +
            " AND CURRENT_DATE());", nativeQuery = true)
    List<Product> serveAds(String categoryName);

    @Query(value = "SELECT p.* " +
            "FROM products p " +
            "JOIN campaign_product cp ON cp.product_id = p.id " +
            "JOIN campaigns c ON c.id = cp.campaign_id " +
            "WHERE c.start_date BETWEEN DATE_SUB(CURRENT_DATE(),INTERVAL 10 DAY) " +
            "AND CURRENT_DATE() " +
            "AND c.bid = " +
            "(SELECT MAX(bid) " +
            "FROM campaigns c2 " +
            "WHERE c2.start_date " +
            "BETWEEN DATE_SUB(CURRENT_DATE(), INTERVAL 10 DAY)" +
            " AND CURRENT_DATE());", nativeQuery = true)
    List<Product> getProductWithMaxBidOnActiveCampaign();
}
