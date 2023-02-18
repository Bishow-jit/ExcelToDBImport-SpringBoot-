package com.example.ExceltoDIImport.Service;

import com.example.ExceltoDIImport.Helper.ExcelHelper;
import com.example.ExceltoDIImport.Model.Product;
import com.example.ExceltoDIImport.Repository.ProductRepo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    private ProductRepo productrepo;
    public void save(MultipartFile file){
        try{
            List<Product>products= ExcelHelper.ChangeExcelDataToList(file.getInputStream());
            this.productrepo.saveAll(products);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public List<Product>getAllProducts(){
      return this.productrepo.findAll();
    }

}
