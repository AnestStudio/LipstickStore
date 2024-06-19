package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Product;
import org.anest.mystore.service.ReportService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public void outputExcel(List<Product> products, ByteArrayOutputStream stream) throws IOException {

        try (Workbook workbook = new XSSFWorkbook();) {
            Sheet sheet = workbook.createSheet(Product.class.getName());

            setHeaderFormatDisplay(workbook, sheet);

            int rowCount = 1;
            for (Product product : products) {
                Row row = sheet.createRow(rowCount++);

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

    private void setHeaderFormatDisplay(Workbook workbook, Sheet sheet) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();

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

        font.setBold(true);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row headerRow = sheet.createRow(0);
        for(int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
        }
    }
}
