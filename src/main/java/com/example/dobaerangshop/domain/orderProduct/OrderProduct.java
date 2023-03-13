package com.example.dobaerangshop.domain.orderProduct;

import com.example.dobaerangshop.domain.order.model.Order;
import com.example.dobaerangshop.domain.product.model.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_PRODUCT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "ORDER_PRICE", nullable = false)
    private int price;

    @Column(name = "ORDER_COUNT", nullable = false)
    private int count;

}
