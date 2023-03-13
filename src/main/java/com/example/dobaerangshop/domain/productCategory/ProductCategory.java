package com.example.dobaerangshop.domain.productCategory;

import com.example.dobaerangshop.domain.category.Category;
import com.example.dobaerangshop.domain.product.model.Product;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

}
