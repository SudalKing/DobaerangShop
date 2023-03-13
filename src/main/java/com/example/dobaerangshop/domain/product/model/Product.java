package com.example.dobaerangshop.domain.product.model;

import com.example.dobaerangshop.domain.orderProduct.OrderProduct;
import com.example.dobaerangshop.domain.productCategory.ProductCategory;
import com.example.dobaerangshop.global.listener.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PTYPE")
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

//    주문상품 -> 상품 조회가 이루어지고, 상품 -> 주문상품 으로의 조회는 거의 없기에 단방향 설정
//    @OneToMany(mappedBy = "product")
//    private List<OrderProduct> orderProducts = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productCategories = new ArrayList<>();

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_PRICE", nullable = false)
    @Min(value = 0, message = "가격은 0보다 커야합니다!")
    private int price;

    @Column(nullable = false)
    @Min(value = 0, message = "재고는 0보다 커야합니다!")
    private int stock;

    @Column(nullable = false)
    private boolean deleted;

}
