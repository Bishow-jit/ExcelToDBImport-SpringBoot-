package com.example.ExceltoDIImport.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Entity
@Data
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private  String productName;

    private  String productDesc;

    private  double productPrice;

    private  String productCode;


    public void setId(Long id) {
        this.id = id;
    }

    @jakarta.persistence.Id
    public Long getId() {
        return id;
    }
}
