package com.example.dobaerangshop.domain.product.model.floor;

import com.example.dobaerangshop.domain.product.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("F")
public class Floor extends Product {

    private String code;
    private FloorType floorType;

}
