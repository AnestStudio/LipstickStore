package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Product;
import org.anest.mystore.service.ReportService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public void outputExcelListProduct(ByteArrayOutputStream stream, List<Product> products) throws IOException {

        try (XSSFWorkbook workbook = new XSSFWorkbook();) {
            XSSFSheet sheet = workbook.createSheet("products");

            int rowCount = 0;
            XSSFRow headerRow = sheet.createRow(rowCount++);
            String[] headers = {
                    "ID",
                    "PRODUCT NAME",
                    "PRODUCT COLOR",
                    "PRODUCT IMAGE",
                    "PRODUCT PRICE",
                    "PRODUCT QUANTITY",
                    "PRODUCT SHORT DESCRIPTION",
                    "PRODUCT DESCRIPTION",
                    "CATEGORY",
                    "BRAND",
                    "TOTAL IMAGE"
            };
            for (int i = 0; i < headers.length; i++) {
                XSSFCell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            for (Product product : products) {
                XSSFRow row = sheet.createRow(rowCount++);

                int cellCount = 0;
                row.createCell(cellCount++).setCellValue(product.getId());
                row.createCell(cellCount++).setCellValue(product.getProductName());
                row.createCell(cellCount++).setCellValue(product.getProductColor());
                row.createCell(cellCount++).setCellValue(product.getProductImage());
                row.createCell(cellCount++).setCellValue(product.getProductPrice());
                row.createCell(cellCount++).setCellValue(product.getProductQuantity());
                row.createCell(cellCount++).setCellValue(product.getProductShortDescription());
                row.createCell(cellCount++).setCellValue(product.getProductDescription());
                row.createCell(cellCount++).setCellValue(product.getCategory().getCategoryName());
                row.createCell(cellCount++).setCellValue(product.getBrand().getBrandName());
                row.createCell(cellCount).setCellValue(product.getProductImageList().size());
            }
            workbook.write(stream);
        }
    }
}
