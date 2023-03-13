package com.example.dobaerangshop.domain.category;

import com.example.dobaerangshop.domain.productCategory.ProductCategory;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    @OneToMany(mappedBy = "category")
    private List<ProductCategory> categories = new ArrayList<>();

}
