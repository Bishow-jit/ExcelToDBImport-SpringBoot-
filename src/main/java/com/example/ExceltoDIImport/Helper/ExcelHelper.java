package com.example.ExceltoDIImport.Helper;

import com.example.ExceltoDIImport.Model.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {
    public static boolean checkExcelFormate(MultipartFile file){
        String contentType=file.getContentType();
        assert contentType != null;
        return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<Product> ChangeExcelDataToList(InputStream is){
        List<Product>productList=new ArrayList<>();

        try{
            XSSFWorkbook workbook=new XSSFWorkbook(is);
            XSSFSheet sheet=workbook.getSheet("Sheet1");
            boolean first = true;
            for (Row row: sheet) {
                if (first) {
                        first = false;
                        continue;
                    }
                    Product product = new Product();
                    product.setId((long) row.getCell(0).getNumericCellValue());
                    product.setProductName(row.getCell(1).getStringCellValue());
                    product.setProductDesc(row.getCell(2).getStringCellValue());
                    product.setProductPrice(row.getCell(3).getNumericCellValue());
                    product.setProductCode(row.getCell(4).getStringCellValue());

                    productList.add(product);


            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return productList;
    }
}
