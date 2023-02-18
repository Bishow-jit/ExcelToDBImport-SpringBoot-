package com.example.ExceltoDIImport.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Product {
    @Id
    private  Integer productId;

    private  String productName;

    private  String productDesc;

    private  double productPrice;

    private  String productCode;
}
