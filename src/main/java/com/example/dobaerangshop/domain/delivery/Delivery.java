package com.example.dobaerangshop.domain.delivery;

import com.example.dobaerangshop.domain.order.model.Order;
import com.example.dobaerangshop.domain.user.model.Address;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Embedded
    private Address address;

}
