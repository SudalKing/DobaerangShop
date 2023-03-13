package com.example.dobaerangshop.domain.product.model.wallpaper;

import com.example.dobaerangshop.domain.product.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("W")
public class WallPaper extends Product {

    private String code;
    private WallPaperType wallPaperType;

}
