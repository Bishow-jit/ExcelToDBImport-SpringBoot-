package com.example.ExceltoDIImport.Repository;

import com.example.ExceltoDIImport.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
