package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Product;
import org.anest.mystore.service.ReportService;
import org.apache.poi.ss.usermodel.Cell;
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

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("products");

        int rowCount = 0;
        for (Product product : products) {
            XSSFRow row = sheet.createRow(rowCount++);

            int cellCount = 0;
            for(int i = 0; i < Product.class.getDeclaredFields().length; i++) {
                Cell cell = row.createCell(cellCount++);
                if (cellCount == 1)
                    cell.setCellValue(product.getId());
                if (cellCount == 2)
                    cell.setCellValue(product.getProductName());
                if (cellCount == 3)
                    cell.setCellValue(product.getProductColor());
                if (cellCount == 4)
                    cell.setCellValue(product.getProductImage());
                if (cellCount == 5)
                    cell.setCellValue(product.getProductPrice());
                if (cellCount == 6)
                    cell.setCellValue(product.getProductQuantity());
                if (cellCount == 7)
                    cell.setCellValue(product.getProductShortDescription());
                if (cellCount == 8)
                    cell.setCellValue(product.getProductDescription());
                if (cellCount == 9)
                    cell.setCellValue(product.getCategory().getCategoryName());
                if (cellCount == 10)
                    cell.setCellValue(product.getBrand().getBrandName());
                if (cellCount == 11)
                    cell.setCellValue(product.getProductImageList().size());
            }
        }
        workbook.write(stream);
    }
}
