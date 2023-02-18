package com.example.ExceltoDIImport.Controller;

import com.example.ExceltoDIImport.Helper.ExcelHelper;
import com.example.ExceltoDIImport.Model.Product;
import com.example.ExceltoDIImport.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/product/upload")
    public ResponseEntity<?>upload(@RequestParam("file")MultipartFile file){
        if(ExcelHelper.checkExcelFormate(file)){
            this.excelService.save(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to DB"));
        }
        else{
          return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel file only");
        }
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return this.excelService.getAllProducts();
    }
}
